package Restaurant.agents;

import Restaurant.agents.GuestAgent;
import Restaurant.models.AdvancedProduct;
import Restaurant.models.Product;
import jade.core.AID;
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;


public class StockAgent extends Agent {
    private static final Logger logger = Logger.getLogger(GuestAgent.class.getName());
    // Список обьектов, которые подчиняются складу
    ArrayList<AID> products = new ArrayList<AID>();

    protected void setup() {
        // Создание списка продуктов
        Object[] content = getArguments();

        for(AdvancedProduct x : (ArrayList<AdvancedProduct>) content[0]) {
            try {
                Object[] arg = new Object[1];
                arg[0] = x;
                AgentController agentController = getContainerController().createNewAgent(x.getProdName(),
                        "Restaurant.agents.ProductAgent", arg);
                agentController.start();
                AID productAgent = new AID(x.getProdName(), AID.ISLOCALNAME);
                products.add(productAgent);
            } catch (StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Create Stock " + getLocalName());
    }



    // Выполняется 1 раз - после создания посетителя


    protected void takeDown() {
        System.out.println("Visitor agent " + getAID().getName() + " terminating.");
    }
}