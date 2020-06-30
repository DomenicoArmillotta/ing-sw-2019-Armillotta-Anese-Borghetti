package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;

import java.util.List;

public class LimitedPower extends Power {

    private List<Cell> firstWorkerAddableCells;
    private List<Cell> firstWorkerRemovableCells;
    private List<Cell> secondWorkerAddableCells;
    private List<Cell> secondWorkerRemovableCells;

    /* LimitedPower can use its superclass' methods doAction() and getExecutorPointer() */

    //*refactor, eliminare
    public LimitedPower() {
        clearPower();
    }

    /**
     * add or remove cells form the previous computed cells by FindAvailableCells classes.
     * @param addableCells list of selectable cells
     * @param index of the selected workers
     */
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

    /**
     * return the list of available cell doing an algebric-set subtration between addableCell and removableCells
     * @param index worker index ,either 0 or 1;
     * @return list of available Cells for a particular worker given by the index @param
     */
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

    /**
     * override addableCells instead of adding to the existing firstWorkerAddableCells or secondWorkerAvailableCells
     * @param availableCells cells to override
     * @param index index of the worker either 0 or 1;
     */
    public void setAvailableCells(List<Cell> availableCells, int index) {
        if (index == 0) {
            this.firstWorkerAddableCells = availableCells;
        } else {
            this.secondWorkerAddableCells = availableCells;
        }
    }

    /**
     * set to null all the lists preparing them for the next turn
     */
    public void clearPower() {
        this.firstWorkerAddableCells = null;
        this.firstWorkerRemovableCells = null;
        this.secondWorkerAddableCells = null;
        this.secondWorkerRemovableCells = null;
    }

}
