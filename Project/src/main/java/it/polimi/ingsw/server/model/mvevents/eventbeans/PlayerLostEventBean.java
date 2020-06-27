package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class PlayerLostEventBean extends EventBean {
    String loserName;

    public PlayerLostEventBean(String loserName) {

        this.loserName = loserName;
    }

    public void setLoserName(String loserName) {
        this.loserName = loserName;
    }

    public String getLoserName() {
        return loserName;
    }
}
