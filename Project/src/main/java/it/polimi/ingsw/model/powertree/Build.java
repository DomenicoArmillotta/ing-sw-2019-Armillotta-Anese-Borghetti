package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.events.BuildBlockEvent;

import java.util.List;

public class Build extends LimitedPower {

    private Cell cellAfterBuild;

    public Cell getCellAfterBuild() {
        return this.cellAfterBuild;
    }

    @Override
    public void clearPower() {
        super.clearPower();
        cellAfterBuild = null;
    }

    public void setCellAfterBuild(Cell cellAfterBuild) {
        this.cellAfterBuild = cellAfterBuild;
        
    }

    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = this.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;
        List<Cell> availableCells = getAvailableCells(index);
        Cell[][] map = getExecutorPointer().getMap();
        /* Cella su cui voglio costruire */
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (availableCells.contains(map[blockX][blockY])) {
            map[blockX][blockY].setBuildingLevel(map[blockX][blockY].getBuildingLevel().getNext());
            cellAfterBuild = map[blockX][blockY];
            this.setCellAfterBuild(cellAfterBuild);
            return 0;
        }

        pointerBack();
        return -1;  /* [NOTIFY]: Build failed */
    }

}
