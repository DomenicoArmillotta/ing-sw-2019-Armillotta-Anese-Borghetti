package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class Select extends LimitedPower {

    /* Select can use its superclass' method getAvailableCells() */

    private Worker selectedWorker;

    public Worker getSelectedWorker() {
        return this.selectedWorker;
    }

    @Override
    public void clearPower() {
        super.clearPower();
        selectedWorker = null;
    }

    public void setSelectedWorker(Worker selectedWorker) {
        this.selectedWorker = selectedWorker;
    }

    @Override
    public int doAction(int[] userInput) { /* userInput contains the integer coordinates of the Worker to be selected */

        if (userInput == null) {
            return -1; /* Action failed: userInput missing */
        } else {
            int index;
            int selectedWorkerX = userInput[0];
            int selectedWorkerY = userInput[1];
            Cell[][] map = getExecutorPointer().getMap();
            if (map[selectedWorkerX][selectedWorkerY].getWorkerOnCell() == getExecutorPointer().getCurrentPlayer().getFirstWorker())
            {
                index = 0;
            }
            else if (map[selectedWorkerX][selectedWorkerY].getWorkerOnCell() == getExecutorPointer().getCurrentPlayer().getSecondWorker()) {
                index = 1;
            } else {
                return -1;
            }
            if (getExecutorPointer().getNextMove().getAvailableCells(index) != null) {
                /*
                questo è un controllo agguntivo
                */
                if(super.getExecutorPointer().getNextMove().getAvailableCells(index).isEmpty())
                    return -1;
                setSelectedWorker(map[selectedWorkerX][selectedWorkerY].getWorkerOnCell());
                return 0;
            } else {
                return -1; /*Action failed: chosen Worker cannot move after selection */
            }
        }
    }
}
