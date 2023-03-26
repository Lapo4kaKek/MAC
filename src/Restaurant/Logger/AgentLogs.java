package Restaurant.Logger;

import java.util.ArrayList;
import java.util.List;

public class AgentLogs {
    private List<AgentLogEntry> logs = new ArrayList<>();

    public AgentLogs() {
        logs = new ArrayList<>();
    }

    public List<AgentLogEntry> getLogs() {
        return logs;
    }

    public void setLogs(List<AgentLogEntry> logs) {
        this.logs = logs;
    }

    public void addLogEntry(AgentLogEntry logEntry) {
        logs.add(logEntry);
    }
}
