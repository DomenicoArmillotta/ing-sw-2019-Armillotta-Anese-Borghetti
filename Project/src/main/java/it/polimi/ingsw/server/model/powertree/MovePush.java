package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;

/**
 * this additional move, called movePush has this effect: move into an opponent Worker’s
 * space, if their Worker can be
 * forced one space straight backwards to an
 * unoccupied space at any level
 * it is used by the god Minotaur
 */
public class MovePush extends Move {

    /**
     * move into an opponent Worker’s
     * space, if their Worker can be
     * forced one space straight backwards to an
     *  unoccupied space at any level
     *  if return -1 calls the pointerBack()
     * @param userInput the cell where the worker you want to push is located
     * @return 1  MovePush successful else -1 MovePush failed
     */
    public int doAction(int[] userInput) {
        Worker targetWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        int index;
        int tempX, tempY;
        int oldX = selectedWorker.getCurrentPosition().getX();
        int oldY = selectedWorker.getCurrentPosition().getY();
        if (super.doAction(userInput) == -1) {
            /* Do not call pointerBack(): it has already been called in the superclass */
            return -1;
        }
        if (selectedWorker == getExecutorPointer().getCurrentPlayer().getFirstWorker()) {
            index = 0;
        } else index = 1;
        if (targetWorker == null) {
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1; /* [NOTIFY]: MovePush successful */
        } else {
            if (super.getAvailableCells(index).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
                tempX = targetWorker.getCurrentPosition().getX() - oldX;
                tempY = targetWorker.getCurrentPosition().getY() - oldY;
                tempX = targetWorker.getCurrentPosition().getX() + tempX;
                tempY = targetWorker.getCurrentPosition().getY() + tempY;
                targetWorker.setPreviousPosition(targetWorker.getCurrentPosition());
                targetWorker.getPreviousPosition().setWorkerOnCell(selectedWorker);
                targetWorker.setCurrentPosition(super.getExecutorPointer().getMap()[tempX][tempY]);
                targetWorker.getCurrentPosition().setWorkerOnCell(targetWorker);
                getWorkerMovementListener().workerMoved(new WorkerMovementEvent(targetWorker));
                return 1; /* [NOTIFY]: MovePush successful */
            } else {
                pointerBack();
                getFailedActionListener().actionFailed(new FailedActionEvent(this));
                return -1; /* [NOTIFY]: MovePush failed */
            }
        }
    }

}
