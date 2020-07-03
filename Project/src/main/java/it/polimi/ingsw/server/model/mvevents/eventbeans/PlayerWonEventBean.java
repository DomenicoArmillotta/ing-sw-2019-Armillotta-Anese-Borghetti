package it.polimi.ingsw.server.model.mvevents.eventbeans;
/**
 * create PlayerWonEventBean
 */
public class PlayerWonEventBean extends EventBean {
    String eventType;
    String winnerName;
    /**
     *is the constructor of PlayerWonEventBean which will be sent to the client by the server to communicate the player that has won
     * @param winnerName NickName of the player who won
     */
    public PlayerWonEventBean(String winnerName) {
        eventType = "PlayerWonEvent";
        this.winnerName = winnerName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getWinnerName() {
        return winnerName;
    }
}
