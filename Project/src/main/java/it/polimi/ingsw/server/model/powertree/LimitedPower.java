package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;

import java.util.List;

public class LimitedPower extends Power {

    private List<Cell> firstWorkerAddableCells;
    private List<Cell> firstWorkerRemovableCells;
    private List<Cell> secondWorkerAddableCells;
    private List<Cell> secondWorkerRemovableCells;

    /* LimitedPower can use its superclass' methods doAction() and getExecutorPointer() */

    public LimitedPower() {
        clearPower();
    }

    public void addCells(List<Cell> addableCells, int index) {
        if (index == 0)
            this.firstWorkerAddableCells.addAll(addableCells);
        else
            this.secondWorkerAddableCells.addAll(addableCells);
    }

    public void removeCells(List<Cell> removableCells, int index) {
        if (index == 0) {
            firstWorkerRemovableCells = removableCells;
        } else {
            secondWorkerRemovableCells = removableCells;
        }
    }

    /* getAvailableCells returns the algebraic subtraction between AddableCells and RemovableCells */
    public List<Cell> getAvailableCells(int index) {
        if (index == 0) {
            List<Cell> availableCells1 = firstWorkerAddableCells;
            if (firstWorkerRemovableCells != null) availableCells1.removeAll(firstWorkerRemovableCells);
            return availableCells1;
        } else {
            List<Cell> availableCells2 = secondWorkerAddableCells;
            if (secondWorkerRemovableCells != null) availableCells2.removeAll(secondWorkerRemovableCells);
            return availableCells2;
        }
    }

    public void setAvailableCells(List<Cell> availableCells, int index) {
        if (index == 0) {
            this.firstWorkerAddableCells = availableCells;
        } else {
            this.secondWorkerAddableCells = availableCells;
        }
    }

    public void clearPower() {
        this.firstWorkerAddableCells = null;
        this.firstWorkerRemovableCells = null;
        this.secondWorkerAddableCells = null;
        this.secondWorkerRemovableCells = null;
    }

}
