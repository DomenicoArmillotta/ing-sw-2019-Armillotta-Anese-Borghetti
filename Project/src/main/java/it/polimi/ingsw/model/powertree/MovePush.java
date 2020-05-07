package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.events.FailedActionEvent;
import it.polimi.ingsw.model.events.NoUpdatesEvent;
import it.polimi.ingsw.model.events.WorkerMovementEvent;

public class MovePush extends Move {

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
            return 0; /* [NOTIFY]: MovePush successful */
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
                return 0; /* [NOTIFY]: MovePush successful */
            } else {
                pointerBack();
                getFailedActionListener().actionFailed(new FailedActionEvent(this));
                return -1; /* [NOTIFY]: MovePush failed */
            }
        }
    }

}
