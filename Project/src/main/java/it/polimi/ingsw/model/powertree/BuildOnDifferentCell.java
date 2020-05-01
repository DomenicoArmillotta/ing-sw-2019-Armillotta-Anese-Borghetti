package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

public class BuildOnDifferentCell extends Build {

    @Override
    public int doAction(int[] userInput) {

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]] == getExecutorPointer().getPrevBuild().getCellAfterBuild()) {
            pointerBack();
            return -1; /* [NOTIFY]: BuildOnDifferentCell failed */
        } else {
            if (super.doAction(userInput) == -1)
                return -1; /* Do not call pointerBack() */
        }
        return 0; /* [NOTIFY]: BuildOnDifferentCell successful */
    }

}
