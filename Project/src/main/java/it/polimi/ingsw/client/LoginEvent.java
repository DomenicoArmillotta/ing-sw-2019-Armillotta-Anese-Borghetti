package it.polimi.ingsw.client;

public class LoginEvent {
    String payload;
    String eventType;

    public LoginEvent(String payload) {
        this.payload = payload;
        this.eventType = "LoginEvent";
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
