package it.polimi.ingsw.model;

import it.polimi.ingsw.model.powertree.Power;

import java.util.List;

public class WaitingForEvent implements Event {
    Power nextPower;
    List<Cell> availableCells;

    public WaitingForEvent(Power nextPower, List<Cell> availableCells) {
        this.nextPower = nextPower;
        this.availableCells = availableCells;
    }

    public Power getNextPower() {
        return nextPower;
    }

    public List<Cell> getAvailableCells() {
        return availableCells;
    }

}
