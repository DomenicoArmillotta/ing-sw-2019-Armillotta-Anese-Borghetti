package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Level;
import it.polimi.ingsw.model.Worker;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsBuildDifferentCell  extends FindAvailableCellsBuild{
    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        Worker workerSelected =  super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell[][] map = super.getExecutorPointer().getMap();
        List<Cell> toRemoveCell = new ArrayList<>();
        int i;

        if (workerSelected.equals(super.getExecutorPointer().getCurrentPlayer().getFirstWorker()))
            i = 0;
        else
            i = 1;

        super.getExecutorPointer().getNextBuild().removeCells((List<Cell>) super.getExecutorPointer().getPrevBuild().getCellAfterBuild(),i);
        if(super.getExecutorPointer().getNextBuild().getAvailableCells(i).isEmpty()) {
            return 1;/*special return value*/
        }
        return 0;
    }
}
