package it.polimi.ingsw.server.model.mvevents.eventbeans;
import java.util.List;

public class WaitingForActionEventBean extends EventBean {
    String eventType;
    List<Integer> coordinates;

    public WaitingForActionEventBean(List<Integer> coordinates) {
        eventType = "WaitingForActionEvent";
        this.coordinates = coordinates;
    }
}
