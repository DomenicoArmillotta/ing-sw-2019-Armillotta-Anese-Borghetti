package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class FailedActionEventBean extends EventBean {
    String eventType;

    public FailedActionEventBean(){
        eventType = "BuildBlockEvent";
    }
}
