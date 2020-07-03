package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create PlayerLostEventBean
 */
public class PlayerLostEventBean extends EventBean {
    String loserName;

    /**
     *is the constructor of PlayerLostEventBean which will be sent to the client by the server to communicate the player that has lost
     * @param loserName
     */
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
