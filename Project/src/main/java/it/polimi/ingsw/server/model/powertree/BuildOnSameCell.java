package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

/**
 * Build a second block on one of the available cells, which must be the same of the previous built cell
 */

public class BuildOnSameCell extends Build {

    /**
     * Calls the superclass' doAction if userInput correctly represents the same cell to build on
     * @param userInput
     * @return 1 if userInput correctly represents the same cell to build on, -1 if the action fails
     * The BuildBlockListener is called in the superclass
     */

    @Override
    public int doAction(int[] userInput) {
        /* se passa lo stesso valore allora non deve costruire */
        if(getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition().getX() == userInput[0] && getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition().getY() == userInput[1])
            return 1;
        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]].getBuildingLevel().equals(Level.TOP) || getExecutorPointer().getMap()[userInput[0]][userInput[1]] != getExecutorPointer().getPrevBuild().getCellAfterBuild()) {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: BuildOnSameCell failed */
        } else {
            if (super.doAction(userInput) == -1)
                return -1; /* Do not call pointerBack() */
        }
        getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
        return 1; /* [NOTIFY]: BuildOnSameCell successful */
    }

}
