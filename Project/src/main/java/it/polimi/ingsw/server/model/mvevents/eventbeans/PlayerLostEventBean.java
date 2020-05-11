package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class PlayerLostEventBean extends EventBean {
    String eventType;
    String loserName;

    public PlayerLostEventBean(String loserName) {
        eventType = "PlayerLostEvent";
        this.loserName = loserName;
    }
}
