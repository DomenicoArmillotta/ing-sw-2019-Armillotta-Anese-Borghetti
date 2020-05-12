package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class PlayerLostEventBean extends EventBean {
    String eventType;
    String loserName;

    public PlayerLostEventBean(String loserName) {
        eventType = "PlayerLostEvent";
        this.loserName = loserName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setLoserName(String loserName) {
        this.loserName = loserName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getLoserName() {
        return loserName;
    }
}
