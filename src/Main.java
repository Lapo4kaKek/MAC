import Restaurant.agents.Constants;
import Restaurant.models.Guest;
import jade.Boot;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Main {
    public static void main(String[] args) {
        JsonLogger jsonLogger = new JsonLogger();
        jsonLogger.addStringToJsonFile("Hello world!");
        System.out.println("Hello world!");
        Parser parser = new Parser();
        parser.JsonParse();
        String[] jadeArgs = {"-gui"};
        Boot.main(jadeArgs);
        try {
            // Создаем платформу
            jade.core.Runtime rt = jade.core.Runtime.instance();
            Profile pMain = new ProfileImpl();
            pMain.setParameter(Profile.MAIN_HOST, "localhost");
            pMain.setParameter(Profile.MAIN_PORT, "1099");

            // Запускаем платформу
            ContainerController cc = rt.createMainContainer(pMain);
            Object aboba[] = {parser.getCookers(), parser.getEquipments(), parser.getAdvancedProducts(), parser.getDishcard()};;
            // Создаем нового агента (агента менеджера)
            AgentController manager = cc.createNewAgent(Constants.SupervisorName, "Restaurant.agents.ManagerAgent", aboba);
            int count = 0;
            manager.start();
            for (Guest el : parser.getGuests()) {
                Object ilikekpo[] = {parser.getOneGuest(count)};
                count++;
                AgentController guest = cc.createNewAgent(el.getVisName(), "Restaurant.agents.GuestAgent", ilikekpo);
                guest.start();
            }
            // Запускаем агента

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
