package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.mvevents.actionevents.BuildBlockEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;

import java.util.List;

/**
 * Build a block on one of the available cells
 * Contains cellAfterBuild attribute, which is the cell that has been built on during the last turn
 */

public class Build extends LimitedPower {

    private Cell cellAfterBuild;

    public Cell getCellAfterBuild() {
        return this.cellAfterBuild;
    }

    /**
     * Calls the superclass' clearPower and set to null cellAfterBuild attribute
     */
    @Override
    public void clearPower() {
        super.clearPower();
        cellAfterBuild = null;
    }

    /**
     * Sets cellAfterBuild attribute
     * @param cellAfterBuild cell of the previous build
     */
    public void setCellAfterBuild(Cell cellAfterBuild) {
        this.cellAfterBuild = cellAfterBuild;
        
    }

    /**
     * d
     * @param userInput user input for building
     * @return 1 if there is no userInput (fake build), or if userInput correctly represents one of the availableCells
     *         -1 if userInput is not correct
     *         Notifies the BuildBlockListener in case of success, the FailedActionListener otherwise
     */
    @Override
    public int doAction(int[] userInput) {

        int index;
        /* refactor */ /* if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1; */
        index = getWorkerIndex();
        List<Cell> availableCells = getAvailableCells(index);
        Cell[][] map = getExecutorPointer().getMap();
        /* Cella su cui voglio costruire */
        if(userInput == null)
            return 1;
        else {
            int blockX = userInput[0];
            int blockY = userInput[1];
            if (availableCells.contains(map[blockX][blockY])) {
                map[blockX][blockY].setBuildingLevel(map[blockX][blockY].getBuildingLevel().getNext());
                cellAfterBuild = map[blockX][blockY];
                this.setCellAfterBuild(cellAfterBuild);
                getBuildBlockListener().buildBlock(new BuildBlockEvent(map[blockX][blockY]));
                return 1;
            }
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1;  /* [NOTIFY]: Build failed */
        }
    }
}
