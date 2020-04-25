package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

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
        List<Cell> availableCells = getAvailableCells(0);
        Cell[][] map = getExecutorPointer().getMap();
        //cella su cui voglio costruire
        int blockX = userInput[0];
        int blockY = userInput[1];
        if (availableCells.contains(map[blockX][blockY])) {
            map[blockX][blockY].setBuildingLevel(map[blockX][blockY].getBuildingLevel().getNext());
            cellAfterBuild = map[blockX][blockY];
            this.setCellAfterBuild(cellAfterBuild);

            return 0;
        }

        return -1;
    }
}
