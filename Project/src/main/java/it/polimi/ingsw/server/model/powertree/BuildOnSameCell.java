package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

public class BuildOnSameCell extends Build {

    @Override
    public int doAction(int[] userInput) {

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]].getBuildingLevel().equals(Level.TOP) || getExecutorPointer().getMap()[userInput[0]][userInput[1]] != getExecutorPointer().getPrevBuild().getCellAfterBuild()) {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: BuildOnSameCell failed */
        } else {
            if (super.doAction(userInput) == -1)
                return -1; /* Do not call pointerBack() */
        }
        getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
        return 0; /* [NOTIFY]: BuildOnSameCell successful */
    }

}
