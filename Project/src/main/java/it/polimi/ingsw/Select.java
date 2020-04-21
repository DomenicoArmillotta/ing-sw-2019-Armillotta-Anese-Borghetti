package it.polimi.ingsw;

import java.util.List;

public class Select extends SelectMove {
    //List<Cell> AvailableCells;

    @Override
    public void setAvailableCells(List<Cell> availableCells) {

        super.setAvailableCells(availableCells);
    }

    @Override
    public List<Cell> getAvailableCells() {
        //System.out.println("Here");
        //System.out.println(super.getClass().toString());
        return super.getAvailableCells();
    }

    @Override
    public int doAction(int[] userInput) {
        int x;
        int y;
        if (userInput != null) {
            x = userInput[0];
            y = userInput[1];
        } else {
            return -1;
        }

        if (getAvailableCells().contains(super.getExecutorPointer().getMap()[x][y])) {
            super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(1).setSelectedWorker(super.executorPointer.getMap()[x][y].getWorkerOnCell());
            return 0;
        }
        return -1;
    }
}
