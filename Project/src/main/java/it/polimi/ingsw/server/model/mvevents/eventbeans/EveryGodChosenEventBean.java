package it.polimi.ingsw.server.model.mvevents.eventbeans;

public class EveryGodChosenEventBean extends EventBean {
    String eventType;

    public EveryGodChosenEventBean(){
        eventType = "EveryGodChosenEventBean";
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
