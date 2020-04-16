package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class ReturnBuildOptionsDifferentBuildingConcrete implements ReturnBuildOptionsStrategy {
    @Override
    public List<Cell> doReturnBuildOptions(Worker selectedWorker) {
        List<Cell> buildOptionsCells = new ArrayList<>();
        Cell[][] map = selectedWorker.getOwner().getCurrentMatch().getMap();
        Cell focusedCell = selectedWorker.getCurrentPosition();
        int cellX = focusedCell.getX();
        int cellY = focusedCell.getY();
        for (int i = cellX - 1; i <= cellX + 1; i++) {
            for (int j = cellY + 1; j >= cellY - 1; j--) {
                if ((i >= 0 && i < 5 && j >= 0 && j < 5) && !(i == cellX && j == cellY)) {
                    if (!(map[i][j].getBuildingLevel().equals(Level.DOME))) {
                        if ((map[i][j].getWorkerOnCell() == null) && (map[i][j].getBuildingLevel().equals(map[i][j].getPreviousLevel())))
                            buildOptionsCells.add(map[i][j]);
                    }
                }
            }
        }
        return buildOptionsCells;
    }
}
