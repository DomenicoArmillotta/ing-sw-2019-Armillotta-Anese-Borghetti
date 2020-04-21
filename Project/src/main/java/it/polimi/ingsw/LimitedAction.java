package it.polimi.ingsw;

import java.util.List;

public class LimitedAction extends Power {
    private List<Cell> availableCells;
    List<Cell> removableCells;
    Worker selectedWorker;

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    public Worker getSelectedWorker() {
        return selectedWorker;
    }

    public void setAvailableCells(List<Cell> availableCells) {

        this.availableCells = availableCells;
    }

    public List<Cell> getAvailableCells() {
        return this.availableCells;
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
