package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCells extends Power {
    int num;

    private boolean lookAround(Worker worker, Cell[][] map) {
        Cell workersCell = worker.getCurrentPosition();
        int i, j;
        boolean canSelectWorker = false;
        int tempX = worker.getCurrentPosition().getX();
        int tempY = worker.getCurrentPosition().getY();
        int deltaLevel;

        for (i = tempX - 1; i < tempX + 2; i++) {
            for (j = tempY + 1; j > tempY - 2; j--) {
                if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                    if (map[i][j].getWorkerOnCell() == null && map[i][j].getBuildingLevel() != Level.DOME) {
                        deltaLevel = (map[i][j].getBuildingLevel().ordinal()) - (worker.getCurrentPosition().getBuildingLevel().ordinal());
                        if (deltaLevel < 2) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    public boolean loseCheck(List<Cell> availableCells) {
        if (availableCells == null)
            return true;
        return false;
    }

    public int doAction(int[] userInput) {
        Player currentPlayer = super.executorPointer.getCurrentActualTurn().getPlayer();
        Cell[][] map = super.executorPointer.getMap();
        List<Cell> tempCells = new ArrayList();
        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (map[i][j].getWorkerOnCell() != null && ((currentPlayer.getFirstWorker() == map[i][j].getWorkerOnCell()) || (currentPlayer.getSecondWorker() == map[i][j].getWorkerOnCell()))) {
                    if (lookAround(map[i][j].getWorkerOnCell(), map)) {
                        tempCells.add(map[i][j]);
                    }
                }
            }
        }

        super.executorPointer.getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(tempCells);
        return 0;
    }
}
