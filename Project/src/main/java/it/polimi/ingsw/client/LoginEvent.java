package it.polimi.ingsw.client;
/**
 * the event is sent to the server by the client,with the login payload
 */
public class LoginEvent extends ClientEvent{
    String payload;

    public LoginEvent(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
