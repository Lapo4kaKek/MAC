package Restaurant.agents;

import Restaurant.Logger.AgentLogger;
import Restaurant.models.AdvancedProduct;
import Restaurant.models.Product;
import jade.core.AID;
import jade.core.Agent;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;


public class ProductAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    // Список обьектов, которые подчиняются складу
    AdvancedProduct product;

    protected void setup() {
        // Создание списка продуктов
        Object[] content = getArguments();
        product = (AdvancedProduct) content[0];
        logger.info("Create Product " + getLocalName());
        AgentLogger.logMessage("Admin", "Create Product " + getLocalName());
    }

    // Выполняется 1 раз - после создания посетителя


    protected void takeDown() {
        System.out.println("Product agent " + getAID().getName() + " terminating.");
    }
}