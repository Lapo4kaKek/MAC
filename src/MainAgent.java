import Restaurant.Restaurant;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

// Главный агент для инициализации ресторана
// Должен считать json'ы и раскидать их
public class MainAgent extends Agent {
    private Restaurant restaurant;

    protected void setup() {
        // создаем экземпляр класса ресторана
        restaurant = new Restaurant();
        // добавляем поведение для чтения входящих JSON-файлов
        addBehaviour(new ReadJsonBehaviour());
    }

    private class ReadJsonBehaviour extends CyclicBehaviour {
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            ACLMessage msg = receive(mt);
            if (msg != null) {
                String content = msg.getContent();
                // обработка входящего JSON-файла
                Parser parser = new Parser();
                //parser.JsonSerialize();

            } else {
                block();
            }
        }

    }
    // завершает цикл
    protected void takeDown() {
        // логика завершения работы агента
        System.out.println("Agent " + getLocalName() + " is shutting down.");
    }
}



