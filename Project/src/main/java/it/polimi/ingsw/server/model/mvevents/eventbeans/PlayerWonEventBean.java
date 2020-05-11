package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class PlayerWonEventBean extends EventBean {
    String eventType;
    String winnerName;

    public PlayerWonEventBean(String winnerName) {
        eventType = "PlayerWonEvent";
        this.winnerName = winnerName;
    }
}
