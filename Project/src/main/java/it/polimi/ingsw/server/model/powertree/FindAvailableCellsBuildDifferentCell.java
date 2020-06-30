package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * extends FindAvailableCells , override doAction() and compute cells for building a second time but not on the
 * same call as previous build;
 */

public class FindAvailableCellsBuildDifferentCell  extends FindAvailableCellsBuild{
    /**
     * call super.doAction() and remove form buildable the cell where the same worker previously built;
     * @param userInput this method doesn't require a particular userInput;
     * @return 1 for autonomously execute the next Power;
     */
    @Override
    public int doAction(int[] userInput) {
        System.out.println("In find availablecellsbuildondifferentcell");
        super.doAction(userInput);
        List<Cell> toRemoveCell = new ArrayList<>();
        int workerIndex;

        workerIndex = getWorkerIndex();

        toRemoveCell.add(super.getExecutorPointer().getPrevBuild().getCellAfterBuild());
        super.getExecutorPointer().getNextBuild().removeCells(toRemoveCell, workerIndex);
        if (super.getExecutorPointer().getNextBuild().getAvailableCells(workerIndex).isEmpty()) {
            return 1;
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextBuild().getAvailableCells(workerIndex)));
        return 1;
    }
}
