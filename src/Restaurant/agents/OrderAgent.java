package Restaurant.agents;

import Restaurant.agents.GuestAgent;
import Restaurant.models.DishCard;
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


public class OrderAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    ArrayList<DishCard> dishes = new ArrayList<DishCard>();

    protected void setup() {
        // Создание заказа Гостя
        logger.info("Create Order with dishes: \n" );
        //Object[] obj = getArguments();
        //dishes = (ArrayList<DishCard>) obj[0];
        //for (DishCard x : dishes) {
            //logger.info(x.getDishName());
        //}
    }

    // Выполняется 1 раз - после создания посетителя


    protected void takeDown() {
        System.out.println("Order agent " + getAID().getName() + " terminating.");
    }
}