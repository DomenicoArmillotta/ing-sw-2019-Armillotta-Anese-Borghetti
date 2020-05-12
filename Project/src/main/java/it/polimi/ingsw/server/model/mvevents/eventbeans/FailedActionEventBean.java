package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class FailedActionEventBean extends EventBean {
    String eventType;

    public FailedActionEventBean(){
        eventType = "FailedActionEvent";
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
