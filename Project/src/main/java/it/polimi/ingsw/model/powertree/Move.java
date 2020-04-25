package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.List;

public class Move extends LimitedPower {

    private Cell cellAfterMove;

    public Cell getCellAfterMove() {
        return this.cellAfterMove;
    }

    @Override
    public void clearPower() {
        super.clearPower();
        cellAfterMove = null;
    }

    public void setCellAfterMove(Cell cellAfterMove) {
        this.cellAfterMove = cellAfterMove;
    }

    //Worker selectedWorker;
    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();

        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) {
            index = 0;
        } else index = 1;
        List<Cell> availableCells = super.getAvailableCells(index);

        Cell previousPosition = selectedWorker.getCurrentPosition();
        if (availableCells == null) {
            return -1;
        } else {
            if (!availableCells.contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                return -1; /* deve rifare la move*/
            } else {
                selectedWorker.setPreviousPosition(previousPosition);
                selectedWorker.getPreviousPosition().setWorkerOnCell(null);
                selectedWorker.setCurrentPosition(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]]);
                selectedWorker.getCurrentPosition().setWorkerOnCell(selectedWorker);
                this.setCellAfterMove(selectedWorker.getCurrentPosition());
                return 0;
            }
        }
    }
}


