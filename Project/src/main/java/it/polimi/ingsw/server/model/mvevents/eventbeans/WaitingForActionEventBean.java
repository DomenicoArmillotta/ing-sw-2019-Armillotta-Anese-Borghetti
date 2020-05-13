package it.polimi.ingsw.server.model.mvevents.eventbeans;
import it.polimi.ingsw.server.model.mvevents.actionevents.Coordinates;

import java.util.List;

public class WaitingForActionEventBean extends EventBean {
    String eventType;
    List<Coordinates> coordinates;

    public WaitingForActionEventBean(List<Coordinates> coordinates) {
        eventType = "WaitingForActionEvent";
        this.coordinates = coordinates;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public String getEventType() {
        return eventType;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
}
