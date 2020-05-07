package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.events.FailedActionEvent;
import it.polimi.ingsw.model.events.NoUpdatesEvent;
import it.polimi.ingsw.model.events.WorkerMovementEvent;
import it.polimi.ingsw.virtualview.listeners.NoUpdatesListener;

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
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: MoveButDontGoBack failed */
        } else {
            if (super.doAction(userInput) == -1)
                return -1; /* Do not call pointerBack(): it has already been called in the superclass */
        }
        /* Chi si è mosso? */
        this.getExecutorPointer().getPrevSelect().setSelectedWorker(selectedWorker);
        getNoUpdatesListener().noUpdates(new NoUpdatesEvent()); /* verificare che sia corretto */
        return 0; /* [NOTIFY]: MoveButDontGoBack successful */
    }

}
