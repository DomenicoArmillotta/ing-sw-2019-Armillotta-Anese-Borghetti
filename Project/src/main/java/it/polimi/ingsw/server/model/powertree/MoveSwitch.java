package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;

public class MoveSwitch extends Move {

    @Override
    public int doAction(int[] userInput) {
        System.out.println("In move switch");
        Worker floatingWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Cell floatingCell = super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition();

        if (super.doAction(userInput) == -1) {
            /* Do not call pointerBack(): it has already been called in the superclass */
            /* getFailedActionListener().actionFailed(new FailedActionEvent(this)); */
            return -1;
        }
        if (floatingWorker == null) {
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1; /* [NOTIFY]: MoveSwitch successful */
        } else if (super.getAvailableCells(0).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
            floatingWorker.setPreviousPosition(floatingWorker.getCurrentPosition());
            floatingWorker.getPreviousPosition().setWorkerOnCell(super.getExecutorPointer().getPrevSelect().getSelectedWorker());
            floatingWorker.setCurrentPosition(floatingCell);
            floatingWorker.getCurrentPosition().setWorkerOnCell(floatingWorker);
            /* setState() -> floatingWorker si è mosso da previousPosition a currentPosition */
            getWorkerMovementListener().workerMoved(new WorkerMovementEvent(floatingWorker));
            return 1; /* [NOTIFY]: MoveSwitch successful */
        } else {
            pointerBack();
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return -1; /* [NOTIFY]: MoveSwitch failed */
        }
    }

}
