package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Worker;

import java.util.List;

public class MoveButDontGoBack extends Move {

    //Worker selectedWorker;
    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;
        List<Cell> availableCells = super.getAvailableCells(index);
        Cell previousPosition = selectedWorker.getCurrentPosition();
        if (previousPosition == getCellAfterMove()) {
            return -1;
        } else
            super.doAction(userInput);

        this.getExecutorPointer().getPrevSelect().setSelectedWorker(selectedWorker);
        return 0;
    }
}


