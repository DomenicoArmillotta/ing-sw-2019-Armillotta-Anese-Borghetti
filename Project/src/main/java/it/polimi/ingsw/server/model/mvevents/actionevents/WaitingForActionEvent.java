package it.polimi.ingsw.server.model.mvevents.actionevents;

import it.polimi.ingsw.client.CoordsEvent;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.WaitingForActionEventBean;
import it.polimi.ingsw.server.model.powertree.Power;

import java.util.ArrayList;
import java.util.List;

public class WaitingForActionEvent extends ActionEvent { /* Waiting for select / Waiting for build */
    Power nextPower;
    List<Cell> availableCells;

    public WaitingForActionEvent(List<Cell> availableCells, Power nextPower) {
        this.nextPower = nextPower;
        this.availableCells = availableCells;
    }

    private Power getNextPower() {
        return nextPower;
    }

    private List<Cell> getAvailableCells() {
        return availableCells;
    }

    public EventBean eventMethod() {
        /* List<int[]> coordinates = new ArrayList<>();
        int i;
        for(i = 0; i < availableCells.size(); i++) {
            coordinates.get(i)[0] = availableCells.get(i).getX();
            coordinates.get(i)[1] = availableCells.get(i).getY();
        } */
        List<Coordinates> coordinates = new ArrayList<>();
        int i;
        for(i = 0; i < availableCells.size(); i++) {
            Coordinates c = new Coordinates();
            c.setX(availableCells.get(i).getX());
            c.setY(availableCells.get(i).getY());
            /*
            oldMethod
            coordinates.add(availableCells.get(i).getX());
            coordinates.add(availableCells.get(i).getY());
            */
            coordinates.add(c);
        }
        WaitingForActionEventBean waitingForActionEventBean = new WaitingForActionEventBean(coordinates);
        return waitingForActionEventBean;
    }

}
