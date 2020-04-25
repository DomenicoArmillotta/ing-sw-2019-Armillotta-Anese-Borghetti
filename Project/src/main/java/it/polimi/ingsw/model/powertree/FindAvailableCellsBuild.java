package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsBuild extends FindAvailableCells {
    public int doAction(int[] userInput) {
        Worker selectedWorker = this.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell[][] map = this.getExecutorPointer().getMap();
        int workerX = selectedWorker.getCurrentPosition().getX();
        int workerY = selectedWorker.getCurrentPosition().getY();
        List<Cell> buildableCells = new ArrayList<>();

        for (int i = workerX - 1; i < workerX + 2 && i < 5; i++) {
            for (int j = workerY - 1; j < workerY + 2 && j < 5; j++) {
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                if (map[i][j].getWorkerOnCell() == null && !map[i][j].getBuildingLevel().equals(Level.DOME)) {
                    buildableCells.add(map[i][j]);
                }
            }

            this.getExecutorPointer().getNextBuild().setAvailableCells(buildableCells, 0);
        }
        return 0;
    }
}
