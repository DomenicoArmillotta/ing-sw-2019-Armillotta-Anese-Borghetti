package it.polimi.ingsw;

import java.util.List;

public class Select extends LimitedAction {
    List<Cell> AvailableCells;

    @Override
    public void setAvailableCells(List<Cell> availableCells) {
        AvailableCells = availableCells;
    }

    @Override
    public List<Cell> getAvailableCells() {
        return AvailableCells;
    }

    @Override
    public int doAction(int[] userInput) {
        int x = userInput[0];
        int y = userInput[1];
        if (getAvailableCells().contains(super.executorPointer.getMap()[x][y])) {
            //super.executorPointer.getNextPower().setSelectedWorker(super.executorPointer.getMap()[x][y].getWorkerOnCell(););
            return 0;
        }
        return -1;
    }
}
