package it.polimi.ingsw.client.viewevents;

import java.util.List;

public class WaitingForActionViewEvent extends ViewEvent {
    String eventType;
    List<Integer> coordinates;

    public WaitingForActionViewEvent(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }
}

