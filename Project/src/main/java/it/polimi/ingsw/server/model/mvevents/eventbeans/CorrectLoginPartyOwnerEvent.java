package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class CorrectLoginPartyOwnerEvent extends EventBean{
    private String partyOwner;

    public CorrectLoginPartyOwnerEvent(String nickName) {
        this.partyOwner = nickName;
    }

    public String getPartyOwner() {
        return partyOwner;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }
}
