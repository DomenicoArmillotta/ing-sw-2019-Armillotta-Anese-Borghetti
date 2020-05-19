package it.polimi.ingsw.client;

public class LoginEvent {
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
