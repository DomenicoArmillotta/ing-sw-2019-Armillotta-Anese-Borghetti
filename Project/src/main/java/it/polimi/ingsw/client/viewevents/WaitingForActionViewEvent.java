package it.polimi.ingsw.client.viewevents;

import java.util.List;

public class WaitingForActionViewEvent extends ViewEvent {
    private List<Integer> coordinates;
    private String currTurn;

    public WaitingForActionViewEvent(List<Integer> coordinates,String currTurn) {
        this.coordinates = coordinates;
        this.currTurn = currTurn;
    }
    public boolean startWaiting() {
        return true;
    }
}

