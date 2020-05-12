package it.polimi.ingsw.server.model.mvevents.eventbeans;
import java.util.List;

public class WaitingForActionEventBean extends EventBean {
    String eventType;
    List<Integer> coordinates;

    public WaitingForActionEventBean(List<Integer> coordinates) {
        eventType = "WaitingForActionEvent";
        this.coordinates = coordinates;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setCoordinates(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public String getEventType() {
        return eventType;
    }

    public List<Integer> getCoordinates() {
        return coordinates;
    }
}
