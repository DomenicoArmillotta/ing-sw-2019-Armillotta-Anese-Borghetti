package it.polimi.ingsw.server.model.mvevents.eventbeans;


/**
 *create the CommandFailureEventBean bean that will be sent from the server to the client when Action fail
 */

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
