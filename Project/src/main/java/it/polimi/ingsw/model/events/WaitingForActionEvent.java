package it.polimi.ingsw.model.events;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.powertree.Power;

import java.util.List;

public class WaitingForActionEvent extends Event { /* Waiting for select / Waiting for build */
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

    public void eventMethod() {
        ;
    }

}
