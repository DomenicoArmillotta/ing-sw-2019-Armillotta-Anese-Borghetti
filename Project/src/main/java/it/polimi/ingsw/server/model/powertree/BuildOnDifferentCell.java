package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

/**
 * Build a second block on one of the available cells, which must be different from the previous built cell
 */

public class BuildOnDifferentCell extends Build {

    /**
     * Calls the superclass' doAction if userInput correctly represents a different cell to build on
     * @param userInput array of integer representing user input to where to build
     * @return 1 if userInput correctly represents a different cell to build on, -1 if the action fails
     * The BuildBlockListener is called in the superclass
     */

    @Override
    public int doAction(int[] userInput) {

        if(getExecutorPointer().getMap()[userInput[0]][userInput[1]] == getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition())
            return 1;
        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]] == getExecutorPointer().getPrevBuild().getCellAfterBuild()) {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: BuildOnDifferentCell failed */
        } else {
            if (super.doAction(userInput) == -1)
                return -1; /* Do not call pointerBack() */
        }
        getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
        return 1; /* [NOTIFY]: BuildOnDifferentCell successful */
    }

}
