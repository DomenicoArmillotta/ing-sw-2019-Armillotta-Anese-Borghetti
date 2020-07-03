package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * extends FindAvailableCellsBuild ,override super.doAction();
 */
public class FindAvailableCellsBuildSameCell extends FindAvailableCellsBuild {
    /**
     * call super.doAction() and excludes for BuildableCells the cell where the worker was previously.
     * @param userInput this method doesn't require a particular userInput;
     * @return
     */
    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        Worker workerSelected =  super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int workerIndex = getWorkerIndex();


        if(executorPointer.getPrevBuild().getCellAfterBuild().getBuildingLevel()!=Level.TOP && executorPointer.getPrevBuild().getCellAfterBuild().getBuildingLevel()!=Level.DOME){
            Cell cellAvailable = executorPointer.getPrevBuild().getCellAfterBuild();
            List<Cell> toAddCell = new ArrayList<>();
            toAddCell.add(cellAvailable);
            executorPointer.getNextBuild().setAvailableCells(toAddCell,workerIndex);
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextBuild().getAvailableCells(workerIndex)));
        return 1;
    }
}
