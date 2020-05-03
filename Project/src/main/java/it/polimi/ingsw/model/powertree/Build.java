package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import java.util.List;

public class Build extends LimitedPower {

    private Cell cellAfterBuild;

    private BuildBlockEvent lastBuildEvent;

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
            setState(new BuildBlockEvent(cellAfterBuild));
            if (getListenersList() != null) notifyListeners();
            return 0;
        }

        pointerBack();
        return -1;  /* [NOTIFY]: Build failed */
    }

    public BuildBlockEvent getState() {
        return lastBuildEvent;
    }

    public void setState(BuildBlockEvent lastBuildEvent) {
        this.lastBuildEvent = lastBuildEvent;
    }


}
