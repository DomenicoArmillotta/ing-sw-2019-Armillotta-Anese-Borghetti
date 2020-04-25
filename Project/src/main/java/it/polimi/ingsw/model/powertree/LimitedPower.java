package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class LimitedPower extends Power {

    private List<Cell> addableCells1;
    private List<Cell> removableCells1;
    private List<Cell> addableCells2;
    private List<Cell> removableCells2;

    /* LimitedPower can use its superclass' methods doAction() and getExecutorPointer() */

    public LimitedPower() {
        clearPower();
    }

    public void addCells(List<Cell> addableCells, int index) {
        if (index == 0)
            this.addableCells1.addAll(addableCells);
        else
            this.addableCells2.addAll(addableCells);
    }

    public void removeCells(List<Cell> removableCells, int index) {
        if (index == 0) {
            removableCells1 = removableCells;
            //this.removableCells1.removeAll(removableCells);
        } else {
            removableCells2 = removableCells;
            //this.removableCells2.removeAll(removableCells);
        }
    }

    //la get fa gia la sottrazione algebrica delle classi;
    public List<Cell> getAvailableCells(int index) {
        if (index == 0) {
            List<Cell> availableCells1 = addableCells1;
            if (removableCells1 != null) availableCells1.removeAll(removableCells1);
            return availableCells1;
        } else {
            List<Cell> availableCells2 = addableCells2;
            if (removableCells2 != null) availableCells2.removeAll(removableCells2);
            return availableCells2;
        }
    }

    public void setAvailableCells(List<Cell> availableCells, int index) {
        if (index == 0)
            this.addableCells1 = availableCells;
        else
            this.addableCells2 = availableCells;
    }

    public void clearPower() {
        this.addableCells1 = null;
        this.removableCells1 = null;
        this.addableCells2 = null;
        this.removableCells2 = null;
    }

}
