package Restaurant.agents;

import Restaurant.models.Equipment;
import jade.core.AID;
import jade.core.Agent;
import jade.wrapper.StaleProxyException;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;


public class EquipmentAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    // Список обьектов, которые подчиняются складу
    Equipment cooker;

    protected void setup() {
        // Создание списка продуктов
        Object[] content = getArguments();
        cooker = (Equipment) content[0];
        logger.info("Create Equipment " + getLocalName());
    }

    // Выполняется 1 раз - после создания посетителя


    protected void takeDown() {
        System.out.println("Visitor agent " + getAID().getName() + " terminating.");
    }



}