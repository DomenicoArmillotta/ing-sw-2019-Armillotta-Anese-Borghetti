package it.polimi.ingsw.client.viewevents;

public class PartyLoginViewEvent extends ViewEvent {
    String partyOwner;
    String loggedPlayer;
    public PartyLoginViewEvent(String partyOwner, String loggedPlayer) {
        this.partyOwner = partyOwner;
        this.loggedPlayer = loggedPlayer;
    }
    public boolean startWaiting() {
        return false;
    }
}
