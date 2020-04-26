package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMoveSwitch extends FindAvailableCellsMove {
    public int doAction(int[] userInput) {
        System.out.println("Switch== ");

        super.doAction(userInput);
        Cell[][] map = super.getExecutorPointer().getMap();
        Worker selectedWorker;
        List<Cell> moveCells = new ArrayList<>();

        for (int index = 0; index < 2; index++) {
            if (index == 0) selectedWorker = getExecutorPointer().getCurrentPlayer().getFirstWorker();
            else selectedWorker = getExecutorPointer().getCurrentPlayer().getSecondWorker();

            int i, j, x, y;

            x = selectedWorker.getCurrentPosition().getX();
            y = selectedWorker.getCurrentPosition().getY();
            for (i = x - 1; i < x + 2 && i < 5; i++) {
                for (j = y - 1; j < y + 2 && j < 5; j++) {
                    if (i < 0) i = 0;
                    if (j < 0) j = 0;
                    //se  c'è un operatore non mio    aggiungo nella lista
                    if (map[i][j].getWorkerOnCell() != null && map[i][j].getWorkerOnCell().getOwner() != selectedWorker.getOwner()) {
                        moveCells.add(map[i][j]); /* usare funzione addCells di LimitedAction */
                    }
                }
            }
            super.getExecutorPointer().getNextMove().addCells(moveCells, index);
            moveCells.clear();
        }

        return 0;

    }
}
