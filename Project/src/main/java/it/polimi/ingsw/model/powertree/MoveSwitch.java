package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

public class MoveSwitch extends Move {
    public int doAction(int[] userInput) {
        Worker floatingWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Cell floatingCell = super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition();
        Worker selectedWorker=super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int index;
        super.doAction(userInput);
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) {
            index = 0;
        } else index = 1;
        if (floatingWorker == null) {
            return 0;
        } else if (super.getAvailableCells(0).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
            floatingWorker.setPreviousPosition(floatingWorker.getCurrentPosition());
            floatingWorker.getPreviousPosition().setWorkerOnCell(super.getExecutorPointer().getPrevSelect().getSelectedWorker());
            floatingWorker.setCurrentPosition(floatingCell);
            floatingWorker.getCurrentPosition().setWorkerOnCell(floatingWorker);
            return 0;
        } else
            return -1;
    }
}

