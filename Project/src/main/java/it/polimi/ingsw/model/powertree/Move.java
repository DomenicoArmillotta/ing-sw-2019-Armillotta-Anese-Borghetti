package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class Move extends LimitedPower {

    //Worker selectedWorker;
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells(0);
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell previousPosition=selectedWorker.getCurrentPosition();
        if (availableCells == null) {
            return 0;
        } else {
            if (!availableCells.contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                return -1; /* deve rifare la move*/
            } else {
                selectedWorker.setPreviousPosition(previousPosition);
                selectedWorker.getPreviousPosition().setWorkerOnCell(null);
                selectedWorker.setCurrentPosition(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]]);
                selectedWorker.getCurrentPosition().setWorkerOnCell(selectedWorker);
                return 0;
            }
        }
    }
}


