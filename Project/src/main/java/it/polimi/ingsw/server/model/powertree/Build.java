package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.BuildBlockEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;

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
        System.out.println("In build");
        Worker selectedWorker = this.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;
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
