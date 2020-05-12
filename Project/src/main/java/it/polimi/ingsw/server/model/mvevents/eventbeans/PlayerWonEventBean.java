package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class PlayerWonEventBean extends EventBean {
    String eventType;
    String winnerName;

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
