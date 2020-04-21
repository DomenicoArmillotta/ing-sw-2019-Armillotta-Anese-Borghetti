package it.polimi.ingsw;

import java.util.List;

public class LimitedAction extends Power {
    List<Cell> availableCells;
    List<Cell> removableCells;
    Worker selectedWorker;

    public void setSelectedWorker(Worker selectedWorker) {
    }

    public Worker getSelectedWorker() {
        return null;
    }

    public void setAvailableCells(List<Cell> availableCells) {
        this.availableCells = availableCells;
    }

    public List<Cell> getAvailableCells() {
        return availableCells;
    }

    @Override
    public ActionExecutor getExecutorPointer() {
        return super.getExecutorPointer();
    }


    ;

    public List<Cell> addAvailableCell() {
        return null;
    }

    ;

    public List<Cell> removeAvailableCell() {
        return null;
    }

    ;

    @Override
    public int doAction(int[] userInput) {
        return 0;
    }
}
