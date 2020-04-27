package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Level;
import it.polimi.ingsw.model.Worker;

import java.util.List;

public class BuildOnSameCell extends Build {

    @Override
    public int doAction(int[] userInput) {

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]].getBuildingLevel().equals(Level.TOP) || getExecutorPointer().getMap()[userInput[0]][userInput[1]] != getExecutorPointer().getPrevBuild().getCellAfterBuild()) {
            PointerBack();
            return -1;
        } else {
            if (super.doAction(userInput) == -1)
                return -1;
        }

        return 0;
    }
}
