package it.polimi.ingsw.server.model.powertree;

import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * extends FindAvailableCellsBuild ,override super.doAction();
 */
public class FindAvailableCellsBuildSameCell extends FindAvailableCellsBuild {
    /**
     * call super.doAction()
     * @param userInput this method doesn't require a particular userInput;
     * @return
     */
    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        Worker workerSelected =  super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell[][] map = super.getExecutorPointer().getMap();
        List<Cell> toRemoveCell = new ArrayList<>();
        int workerIndex = getWorkerIndex();

        for (int k = workerSelected.getCurrentPosition().getX() - 1; k < workerSelected.getCurrentPosition().getX() + 2 && k < 5; k++) {
            for (int j = workerSelected.getCurrentPosition().getY() - 1; j < workerSelected.getCurrentPosition().getY() + 2 && j < 5; j++) {
                if (k < 0) k = 0;
                if (j < 0) j = 0;
                if (map[k][j].getBuildingLevel() == Level.TOP){
                    toRemoveCell.add(map[k][j]);
                }
            }
        }
        super.getExecutorPointer().getNextBuild().removeCells(toRemoveCell,workerIndex);
        /*special return value*/
        super.getExecutorPointer().getNextBuild().getAvailableCells(workerIndex);
        return 1;
    }
}
