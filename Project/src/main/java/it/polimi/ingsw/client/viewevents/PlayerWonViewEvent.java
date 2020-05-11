package it.polimi.ingsw.client.viewevents;

public class PlayerWonViewEvent extends ViewEvent {
    String winnerName;
    public PlayerWonViewEvent(String winnerName) {
        this.winnerName = winnerName;
    }
}
