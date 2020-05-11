package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsBuild extends FindAvailableCells {
    public int doAction(int[] userInput) {
        System.out.println("In find availablecellsbuild");

        Worker selectedWorker = this.getExecutorPointer().getPrevSelect().getSelectedWorker();
        Cell[][] map = this.getExecutorPointer().getMap();
        int workerX = selectedWorker.getCurrentPosition().getX();
        int workerY = selectedWorker.getCurrentPosition().getY();
        List<Cell> buildableCells = new ArrayList<>();
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) index = 0;
        else index = 1;

        for (int i = workerX - 1; i < workerX + 2 && i < 5; i++) {
            for (int j = workerY - 1; j < workerY + 2 && j < 5; j++) {
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                if (map[i][j].getWorkerOnCell() == null && !map[i][j].getBuildingLevel().equals(Level.DOME)) {
                    buildableCells.add(map[i][j]);
                }
            }
            this.getExecutorPointer().getNextBuild().setAvailableCells(buildableCells, index);
        }
        /* setState() <- waitingForBuild: these are availableCellsBuild */
        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(buildableCells, null));
        return 0; /* [NOTIFY]: FindAvailableCellsBuild done */
    }

}