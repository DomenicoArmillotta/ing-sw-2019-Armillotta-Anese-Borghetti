package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class BasicShowBuildOptionsConcrete implements ShowBuildOptionsStrategy {
    @Override
    public List<Cell> showBuildOptions(Worker focusedWorker) {
        Cell[][] map = focusedWorker.getOwner().getCurrentMatch().getMap();
        List<Cell> cells = new ArrayList<>();
        Cell focusedCell = focusedWorker.getCurrentPosition();
        int cellX = focusedCell.getX();
        int cellY = focusedCell.getY();
        for (int i = cellX - 1; i <= cellX + 1; i++) {
            for (int j = cellY + 1; j <= cellY - 1; j--) {
                if (i != cellX || j != cellY) {
                    if (!map[cellX][cellY].getBuildingLevel().equals(Level.DOME)) {
                        cells.add(map[cellX][cellY]);
                    }
                }
            }
        }
        return cells;
    }
}
