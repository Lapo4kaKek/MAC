package Restaurant.agents;

import Restaurant.models.*;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;


public class ManagerAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    AID stockAgentAid;
    int count = 1;
    ArrayList<AdvancedProduct> stock = new ArrayList<>();
    HashMap<String, Double> stockTable = new HashMap<String, Double>();
    private ArrayList<AID> orders = new ArrayList<AID>();

    private ArrayList<DishCard> dishes = new ArrayList<DishCard>();

    private ArrayList<AID> cookersagents = new ArrayList<AID>();
    private ArrayList<Cooker> cookers = new ArrayList<Cooker>();
    private ArrayList<AID> equipmentsagent = new ArrayList<AID>();

    private ArrayList<Equipment> equipments = new ArrayList<Equipment>();

    //private ContainerController containerController = getContainerController();

    protected void setup() {
        // Инициализация меню
        // проинициализировать меню
        // Создание Менеджера
        logger.info("Create " + getLocalName());
        Object[] args = getArguments();
        cookers = (ArrayList<Cooker>) args[0];
        equipments = (ArrayList<Equipment>) args[1];
        stock = (ArrayList<AdvancedProduct>) args[2];
        dishes = (ArrayList<DishCard>) args[3];

        for (Cooker x : cookers) {
            try{
                Object[] arg = new Object[1];
                arg[0] = x;
                AgentController controller = getContainerController().createNewAgent(x.getName(),
                        "Restaurant.agents.CookerAgent", arg);
                controller.start();
                AID cookerAgent = new AID(x.getName(), AID.ISLOCALNAME);
                cookersagents.add(cookerAgent);
            } catch (StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }

        // Инициализируем список оборудования
        for (Equipment x : equipments) {
            try{
                Object[] arg = new Object[1];
                arg[0] = x;
                AgentController controller = getContainerController().createNewAgent(x.getName(),
                        "Restaurant.agents.EquipmentAgent", arg);
                controller.start();
                AID equipmentAgent = new AID(x.getName(), AID.ISLOCALNAME);
                equipmentsagent.add(equipmentAgent);
            } catch (StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }

        // Создаем склад с продуктами
        try{
            Object[] arg = new Object[1];
            arg[0] = stock;
            AgentController controller = getContainerController().createNewAgent(Constants.StockName,
                    "Restaurant.agents.StockAgent", arg);
            controller.start();
            stockAgentAid = new AID(Constants.StockName, AID.ISLOCALNAME);

            // создаем таблицу склада
            for (AdvancedProduct x : stock) {
                stockTable.put(x.getProdName(), x.getProdQuantity());
            }
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }

        addBehaviour(new ReceiveMessageBehaviour());
    }

    // Выполняется постоянно - ждет сообщения
    class ReceiveMessageBehaviour extends CyclicBehaviour{

        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            ACLMessage msg = receive(mt);
            if (msg != null) {
                try {
                    Message mes = (Message) msg.getContentObject();
                    switch (mes.message) {
                        case Constants.OrderMessage:
                            logger.info("Manager receive order from " + msg.getSender().getLocalName());
                            try{
                                ArrayList<DishCard> dishesInOrder = new ArrayList<DishCard>();
                                for (VisOrdDish x : mes.id) {
                                    for (DishCard y : dishes) {
                                        //if (x.getOrdDishId() == y.getCardId()) {dishesInOrder.add(y);}
                                        dishesInOrder.add(y);
                                    }
                                }
                                Object[] args = new Object[1];
                                args[0] = dishesInOrder;
                                AgentController controller = getContainerController().createNewAgent("Order" + orders.size() + 1,
                                        "Restaurant.agents.OrderAgent", args);
                                controller.start();
                                AID orderAgent = new AID("Order" + orders.size() + 1, AID.ISLOCALNAME);
                                orders.add(orderAgent);
                                logger.info("We Start to make this Order");
                                addBehaviour(new MakeOrderBehaviour(controller, dishesInOrder, msg.getSender()));
                            } catch (StaleProxyException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }
                } catch (UnreadableException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class MakeOrderBehaviour extends OneShotBehaviour {
        AgentController orderId;

        ArrayList<DishCard> dishesInOrder;
        double totalTime = 0;
        Boolean finished = false;
        AID guestaid;
        MakeOrderBehaviour(AgentController order, ArrayList<DishCard> dishesInOrder, AID id) {
            orderId = order;
            this.dishesInOrder = dishesInOrder;
            for (DishCard x : dishesInOrder) {
                totalTime += x.getCardTime();
            }
            guestaid = id;
        }
        @Override
        public void action() {
            // Проверяем наличие на складе
            Boolean fl = true;
            /*for (DishCard x : dishesInOrder) {
                for (Operation y : x.getOperations()) {
                    for (Product pr : y.getOperProducts()) {
                        if (!stockTable.containsKey(pr.getName()) || stockTable.get(pr.getName())< pr.getQuantity()) {
                            logger.warning("We dont have enough " + pr.getName() + " To make this order");
                            fl = false;
                            break;
                        }
                    }
                }
            }*/
            if (fl) {
                logger.info("We have all products to make this order");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            } else {
                return;
            }
            totalTime -= 0.1 * totalTime;
            addBehaviour(new AnswerAboutTimeBehaviour(0.75 * totalTime, guestaid));

            // Проверяем поваров
            Boolean findCooker = false;
            logger.info("Manager starts to choose the cooker for this order");
            // Логика выбора
            for (int i = 0; i < cookers.size(); i++) {
                if (!cookers.get(i).isActive()) {
                    logger.info("Manager find Cooker without work, name of this Cooker: " + cookers.get(i).getName());
                    findCooker = true;
                }
            }
            if (!findCooker) {
                logger.info("All cookers are busy. Sorry");
                return;
            }
            totalTime -= 0.1 * totalTime;
            addBehaviour(new AnswerAboutTimeBehaviour(0.5 * totalTime, guestaid));
            // Проверяем инвентарь
            //System.out.println(dishesInOrder.size());
            Boolean findEquipment = false;
            for (DishCard x : dishesInOrder) {
                for (Equipment y : equipments) {
                    if (y.getType() == x.getEquipType() && y.getActive()) {
                        logger.info("Manager find Equipment, name of this Equipment: " + y.getName());
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                        }
                        findEquipment = true;
                    }
                }
            }

            if (!findEquipment) {
                logger.info("Manager cant find equipment");
                return;
            }
            //totalTime -= 0.1 * totalTime;
            addBehaviour(new AnswerAboutTimeBehaviour(0.25 * totalTime, guestaid));
            addBehaviour(new CookingOrderBehaviour());
            addBehaviour(new FinishOrderBehaviour());

        }

        class AnswerAboutTimeBehaviour extends OneShotBehaviour {
            double totalTime;
            AID receiver;
            AnswerAboutTimeBehaviour(double t, AID id) {
                totalTime = t;
                receiver = id;
            }
            AnswerAboutTimeBehaviour(double t) {
                totalTime = t;
            }
            @Override
            public void action() {
                try {
                    logger.info("Manager answer to " + guestaid.getLocalName() + " that time before order is ready is " + totalTime);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }

        class CookingOrderBehaviour extends OneShotBehaviour {
            @Override
            public void action() {
                try {
                    logger.info("Cooking...fry me...");
                    addBehaviour(new AnswerAboutTimeBehaviour(0));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
        class FinishOrderBehaviour extends OneShotBehaviour {
            @Override
            public void action() {
                logger.info("Finishing Order #" + count);
                count += 1;
                //Здесь по идее нужно убить агент заказа и ответить гостю, что его заказ готов
                // Также нужно поменять статус поварам и обновить склад
            }
        }
    }



    protected void takeDown() {
        System.out.println("Visitor agent " + getAID().getName() + " terminating.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }
}