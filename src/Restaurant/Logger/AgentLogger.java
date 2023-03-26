package Restaurant.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AgentLogger {
    private static final String FILE_NAME = "logs.json";

    public static void logMessage(String agentName, String message) {
        AgentLogs agentLogs = readAgentLogs();
        agentLogs.addLogEntry(new AgentLogEntry(agentName, message));
        writeAgentLogs(agentLogs);
    }

    private static AgentLogs readAgentLogs() {
        Gson gson = new Gson();
        AgentLogs agentLogs = new AgentLogs();

        if (Files.exists(Paths.get(FILE_NAME))) {
            try (FileReader reader = new FileReader(FILE_NAME)) {
                JsonReader jsonReader = new JsonReader(reader);
                jsonReader.setLenient(true);
                agentLogs = gson.fromJson(jsonReader, AgentLogs.class);
                if (agentLogs == null || agentLogs.getLogs() == null) {
                    agentLogs = new AgentLogs();
                }
            } catch (IOException e) {
                e.printStackTrace();
                agentLogs = new AgentLogs();
            }
        } else {
            agentLogs = new AgentLogs();
        }

        return agentLogs;
    }

    private static void writeAgentLogs(AgentLogs agentLogs) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(agentLogs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
