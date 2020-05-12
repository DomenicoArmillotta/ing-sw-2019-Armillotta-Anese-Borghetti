package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class NoUpdatesEventBean extends EventBean {
    String eventType;

    public NoUpdatesEventBean(){
        eventType = "NoUpdatesEvent";
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
