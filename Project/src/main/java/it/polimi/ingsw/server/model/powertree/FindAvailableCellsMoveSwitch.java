package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * used to return the cells to the god (Apollo) who must be able to  switch
 */
public class FindAvailableCellsMoveSwitch extends FindAvailableCellsMove {

    /**
     * adds to the list of cells found by FindAvailableCellsMove the cells in which it is possible to switch,
     * thus checking that the worker is the opponent
     * @param userInput
     * @return
     */
    public int doAction(int[] userInput) {
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
                    /* Se  c'è un operatore non mio    aggiungo nella lista */
                    if (map[i][j].getWorkerOnCell() != null && map[i][j].getWorkerOnCell().getOwner() != selectedWorker.getOwner()) {
                        moveCells.add(map[i][j]); /* Usare funzione addCells di LimitedAction */
                    }
                }
            }
            super.getExecutorPointer().getNextMove().addCells(moveCells, index);
            moveCells.clear();
        }
        List<Cell> availableCellsSwitch = new ArrayList<>();
        if(super.getExecutorPointer().getNextMove().getAvailableCells(0).size() != 0) {
            availableCellsSwitch.add(getExecutorPointer().getCurrentPlayer().getFirstWorker().getCurrentPosition());
        }
        if(super.getExecutorPointer().getNextMove().getAvailableCells(1).size() != 0) {
            availableCellsSwitch.add(getExecutorPointer().getCurrentPlayer().getSecondWorker().getCurrentPosition());
        }

        getWaitingForActionListener().waitForAction(new WaitingForActionEvent(availableCellsSwitch));
        //getWaitingForActionListener().waitForAction(new WaitingForActionEvent(super.getExecutorPointer().getNextMove().getAvailableCells(0)));
        return 0; /* [NOTIFY]: FindAvailableCellsMoveSwitch done */
    }
}
