package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

public class BuildOnDifferentCell extends Build {

    @Override
    public int doAction(int[] userInput) {
        System.out.println("In build on different cell");
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
