package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class CorrectLoginPartyOwnerEvent extends EventBean{
    private String partyOwner;
    private String loggedPlayer;

    public CorrectLoginPartyOwnerEvent(String partyOwner,String loggedPlayer) {
        this.loggedPlayer = loggedPlayer;
        this.partyOwner = partyOwner;
    }

    public String getPartyOwner() {
        return partyOwner;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }

    public String getLoggedPlayer() {
        return loggedPlayer;
    }

    public void setLoggedPlayer(String loggedPlayer) {
        this.loggedPlayer = loggedPlayer;
    }
}
