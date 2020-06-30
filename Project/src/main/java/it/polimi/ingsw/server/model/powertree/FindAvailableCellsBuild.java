package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Extend FindAvailableCells, override doAction() and compute availableCells for building
 */

public class FindAvailableCellsBuild extends FindAvailableCells {

    /**
     * set the list of buildableCells by looking at  the surrounding cells
     * of the selected worker.If the current level of the cell is Level.Dome @see Level or there is another worker
     * on the same cell, that particular cell is not added to the list.
     * if buildableCells size is empty call loseCondition(), @see FindAvailableCells.
     * notify the list of buildableCells with waitingForActionEvent
     * @param userInput this method doesn't require a particular userInput;
     * @return 1 is buildableCells is empty else 0;
     */

    public int doAction(int[] userInput) {
       // System.out.println("In find availablecellsbuild"); //* refactor

        Worker selectedWorker = this.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell[][] map = this.getExecutorPointer().getMap();
        int workerX = selectedWorker.getCurrentPosition().getX();
        int workerY = selectedWorker.getCurrentPosition().getY();
        List<Cell> buildableCells = new ArrayList<>();
        int workerIndex;
        /*if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;*///*refactor

        workerIndex = getWorkerIndex();


        for (int i = workerX - 1; i < workerX + 2 && i < 5; i++) {
            for (int j = workerY - 1; j < workerY + 2 && j < 5; j++) {
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                if (map[i][j].getWorkerOnCell() == null && !map[i][j].getBuildingLevel().equals(Level.DOME)) {
                    buildableCells.add(map[i][j]);
                }
            }
            this.getExecutorPointer().getNextBuild().setAvailableCells(buildableCells, workerIndex);
        }
        if(this.getExecutorPointer().getNextBuild().getAvailableCells(workerIndex).isEmpty()) {
            loseCondition();
            return 1;
        }
        /* setState() <- waitingForBuild: these are availableCellsBuild */
        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(buildableCells));
        return 0; /* [NOTIFY]: FindAvailableCellsBuild done */
    }

}
