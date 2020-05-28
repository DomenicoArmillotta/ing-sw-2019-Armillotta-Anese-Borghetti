package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

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
        if(userInput[0] == selectedWorker.getCurrentPosition().getX() && userInput[1] == selectedWorker.getCurrentPosition().getY())
            return 1;
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
        return 1; /* [NOTIFY]: MoveButDontGoBack successful */
    }

}
