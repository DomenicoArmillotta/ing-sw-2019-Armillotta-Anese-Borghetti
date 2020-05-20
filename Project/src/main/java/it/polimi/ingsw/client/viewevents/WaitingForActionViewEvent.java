package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.ClientStatus;
import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void viewEventMethod() {
        ClientStatus.instance().setCurrentPlayer(currTurn);
    }
}

