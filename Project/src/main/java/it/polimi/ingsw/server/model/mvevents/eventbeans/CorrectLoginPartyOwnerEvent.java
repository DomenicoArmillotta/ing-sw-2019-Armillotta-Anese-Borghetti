package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create CorrectLoginPartyOwnerEvent
 */
public class CorrectLoginPartyOwnerEvent extends EventBean{
    private String partyOwner;
    private String loggedPlayer;

    /**
     * create CorrectLoginPartyOwnerEvent which will be sent to the client
     *  by the server to communicate the correct party owner
     * @param partyOwner
     * @param loggedPlayer
     */
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
