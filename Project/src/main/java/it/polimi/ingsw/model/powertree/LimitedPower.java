package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class LimitedPower extends Power {

    private List<Cell> addableCells;
    private List<Cell> removableCells;

    /* LimitedPower can use its superclass' methods doAction() and getExecutorPointer() */

    public void addCells(List<Cell> addableCells) {
        this.addableCells = addableCells;
    }

    public void removeCells(List<Cell> removableCells) {
        this.removableCells = removableCells;
    }

    public List<Cell> getAvailableCells() {
        List<Cell> availableCells = addableCells;
        availableCells.removeAll(removableCells);
        return availableCells;
    }

    public void setAvailableCells(List<Cell> availableCells) {
        this.addableCells = availableCells;
    }

    public void clearPower() {
        this.addableCells = null;
        this.removableCells = null;
    }

}
