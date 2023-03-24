import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Parser parser = new Parser();
        parser.JsonParse();
        /*parser.getCookersJson();
        parser.getGuestsJson();
        parser.getDishesCardsJson();
        parser.getEquipmentJson();
        parser.getEquipmentTypeJson();
        parser.getProductTypeJson();
        parser.getMenuJson();
        parser.getProductsJson();*/
    }
}