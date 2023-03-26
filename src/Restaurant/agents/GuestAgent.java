package Restaurant.agents;
import Restaurant.agents.*;
import Restaurant.models.Guest;
import Restaurant.models.Menu;
import Restaurant.models.VisOrdDish;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;


public class GuestAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    private Menu menu;
    ArrayList<VisOrdDish> dishesInOrder;
    int timeBeforeReady = 0;
    private AID managerAgent;
    protected void setup() {
        // Инициализация меню
        // проинициализировать меню

        // Создание Гостя
        logger.info("Create Guest " + getLocalName());
        Object[] args = getArguments();

        dishesInOrder = new ArrayList<VisOrdDish>(((Guest)args[0]).getVisOrdDishes());
        // Поиск агента-управляющего
        try {
            managerAgent = new AID(Constants.SupervisorName, AID.ISLOCALNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addBehaviour(new MakeOrderBehaviour());
    }

    // Выполняется 1 раз - после создания посетителя
    class MakeOrderBehaviour extends OneShotBehaviour{
        private boolean finished = false;

        @Override
        public void action() {
            //dishesInOrder = new ArrayList<>(3);
            ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            message.addReceiver(managerAgent);
            Message mes = new Message(Constants.OrderMessage, dishesInOrder);
            try {
                message.setContentObject(mes);
                send(message);
                logger.info("Guest " + getAID().getName() + " request a menu ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            finished = true;
        }
    }

    protected void takeDown() {
        System.out.println("Visitor agent " + getAID().getName() + " terminating.");
    }
}