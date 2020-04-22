package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class Move extends LimitedPower {

    //Worker selectedWorker;
    @Override
    public int doAction(int[] userInput) {
        List<Cell> availableCells = super.getAvailableCells();
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        if (availableCells == null) {
            System.out.println("chiama routine di perdita");
            return 0;
        } else {
            if (availableCells.contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                return -1; /* deve rifare la move*/
            } else {
                selectedWorker.setPreviousPosition(selectedWorker.getCurrentPosition());
                selectedWorker.setCurrentPosition(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]]);
                return 0;
            }
        }
    }
}


