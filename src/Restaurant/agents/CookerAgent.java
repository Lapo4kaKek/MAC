package Restaurant.agents;

import Restaurant.Logger.AgentLogger;
import Restaurant.models.Cooker;
import jade.core.AID;
import jade.core.Agent;
import jade.wrapper.StaleProxyException;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;


public class CookerAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    // Список обьектов, которые подчиняются складу
    Cooker cooker;

    protected void setup() {
        // Создание списка продуктов
        Object[] content = getArguments();
        cooker = (Cooker) content[0];
        logger.info("Create Cooker " + getLocalName());
        AgentLogger.logMessage("Admin", "Create Cooker " + getLocalName().toString());
    }

    protected void takeDown() {
        System.out.println("Visitor agent " + getAID().getName() + " terminating.");
    }
}