package it.polimi.ingsw.client.viewevents;

public class PlayerLostViewEvent extends ViewEvent {
    String loserName;
    public PlayerLostViewEvent(String loserName) {
        this.loserName = loserName;
    }
}
