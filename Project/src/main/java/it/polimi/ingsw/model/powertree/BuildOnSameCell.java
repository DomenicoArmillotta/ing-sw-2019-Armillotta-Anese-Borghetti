package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Worker;

import java.util.List;

public class BuildOnSameCell extends Build {

    @Override
    public int doAction(int[] userInput) {

        if (getExecutorPointer().getMap()[userInput[0]][userInput[1]] != getExecutorPointer().getPrevBuild().getCellAfterBuild()) {
            return -1;
        } else
            super.doAction(userInput);

        return 0;
    }
}
