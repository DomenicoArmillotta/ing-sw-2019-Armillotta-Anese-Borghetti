package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsBuildDifferentCell  extends FindAvailableCellsBuild{
    @Override
    public int doAction(int[] userInput) {
        System.out.println("In find availablecellsbuildondifferentcell");
        super.doAction(userInput);
        Worker workerSelected =  super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell[][] map = super.getExecutorPointer().getMap();
        List<Cell> toRemoveCell = new ArrayList<>();
        int i;

        if (workerSelected.equals(super.getExecutorPointer().getCurrentPlayer().getFirstWorker()))
            i = 0;
        else
            i = 1;

        super.getExecutorPointer().getNextBuild().removeCells((List<Cell>) super.getExecutorPointer().getPrevBuild().getCellAfterBuild(), i);
        if (super.getExecutorPointer().getNextBuild().getAvailableCells(i).isEmpty()) {
            return 1;/*special return value*/
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextBuild().getAvailableCells(i), null));
        return 0;
    }
}
