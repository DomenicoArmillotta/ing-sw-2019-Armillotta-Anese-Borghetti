package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

import java.util.List;

public class MoveButDontGoBack extends Move {

    /* Worker selectedWorker; */
    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;
        List<Cell> availableCells = super.getAvailableCells(index);
        Cell previousPosition = selectedWorker.getCurrentPosition();

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]] == getExecutorPointer().getPrevMove().getCellBeforeMove()) {
            pointerBack();
            return -1; /* [NOTIFY]: MoveButDontGoBack failed */
        } else {
            if (super.doAction(userInput) == -1)
                return -1; /* Do not call pointerBack(): it has already been called in the superclass */
        }

        this.getExecutorPointer().getPrevSelect().setSelectedWorker(selectedWorker);
        return 0; /* [NOTIFY]: MoveButDontGoBack successful */
    }

}
