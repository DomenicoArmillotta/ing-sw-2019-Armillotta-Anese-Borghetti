package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;

import java.util.List;

/**
 *this class includes the whole family of constructions,
 *that is, all possible types of moves of all gods
 */
public class Move extends LimitedPower {

    private Cell cellBeforeMove;

    public Cell getCellBeforeMove() {
        return this.cellBeforeMove;
    }

    @Override
    public void clearPower() {
        super.clearPower();
        cellBeforeMove = null;
    }

    public void setCellBeforeMove(Cell cellBeforeMove) {
        this.cellBeforeMove = cellBeforeMove;
    }

    /**
     *if the cell passed as a parameter is in the list of cells in which the worker wants to move then the move can be made
     * @param userInput the cell where I want to move
     * @return 1  Move successful else -1 Move failed
     */
    @Override
    public int doAction(int[] userInput) {
        //System.out.println("In move");//*refactor

        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        setCellBeforeMove(selectedWorker.getCurrentPosition());
        int index;
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) {
            index = 0;
        } else index = 1;

        List<Cell> availableCells = super.getAvailableCells(index);

        Cell previousPosition = selectedWorker.getCurrentPosition();
        if (availableCells.isEmpty()) {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: Move failed */
        } else {
            if (!availableCells.contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                pointerBack();
                getFailedActionListener().actionFailed(new FailedActionEvent(this));
                return -1; /* [NOTIFY]: Move failed */
            } else {
                selectedWorker.setPreviousPosition(previousPosition);
                selectedWorker.getPreviousPosition().setWorkerOnCell(null);
                selectedWorker.setCurrentPosition(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]]);
                selectedWorker.getCurrentPosition().setWorkerOnCell(selectedWorker);
                getWorkerMovementListener().workerMoved(new WorkerMovementEvent(selectedWorker));
                return 1; /* [NOTIFY]: Move successful */
            }
        }
    }

}
