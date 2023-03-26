package Restaurant.Logger;

public class AgentLogEntry {
    private String agentName;
    private String message;

    public AgentLogEntry(String agentName, String message) {
        this.agentName = agentName;
        this.message = message;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
