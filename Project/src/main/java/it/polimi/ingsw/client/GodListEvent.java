package it.polimi.ingsw.client;
/**
 * the event is sent to the server by the client,with the information of the list of gods chose by partyOwner
 */
public class GodListEvent extends ClientEvent{
    private String god1;
    private String god2;
    private String god3;

    public GodListEvent(String god1, String god2, String god3) {
        this.god1 = god1;
        this.god2 = god2;
        this.god3 = god3;
    }

    public String getGod1() {
        return god1;
    }

    public void setGod1(String god1) {
        this.god1 = god1;
    }

    public String getGod2() {
        return god2;
    }

    public void setGod2(String god2) {
        this.god2 = god2;
    }

    public String getGod3() {
        return god3;
    }

    public void setGod3(String god3) {
        this.god3 = god3;
    }
}
