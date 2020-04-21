package it.polimi.ingsw;

import java.util.List;

public class SelectMove extends LimitedAction {

    @Override
    public ActionExecutor getExecutorPointer() {
        return super.getExecutorPointer();
    }

    @Override
    public void setAvailableCells(List<Cell> availableCells) {

        super.setAvailableCells(availableCells);
    }

    @Override
    public List<Cell> getAvailableCells() {
        //System.out.println("There");
        return super.getAvailableCells();
    }

    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells();

        return 0;
    }
}
