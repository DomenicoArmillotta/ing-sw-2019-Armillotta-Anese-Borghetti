package it.polimi.ingsw.server.model.mvevents.eventbeans;

/**
 * create CorrectLoginPartyOwnerEvent
 */
public class CorrectLoginPartyOwnerEvent extends EventBean{
    private String partyOwner;
    private String loggedPlayer;

    /**
     * is the constructor of  CorrectLoginPartyOwnerEvent which will be sent to the client
     *  by the server to communicate the correct party owner after checking it on the server
     * @param partyOwner partyOwner
     * @param loggedPlayer logged player
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
