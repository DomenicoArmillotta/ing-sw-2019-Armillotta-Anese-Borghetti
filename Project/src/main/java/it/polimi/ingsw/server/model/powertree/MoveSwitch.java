package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;

/**
 * this additional move, called MoveSwitch has this effect:
 * move into an opponent Worker’s
 * space by forcing their Worker to
 * the space yours just vacated.
 * it is used by the god apollo
 */
public class MoveSwitch extends Move {
    /**
     * if in the cell passed as parameter there is a worker then I make the switch
     * @param userInput the cell where the worker you want to switch is located
     * @return 1  MoveSwitch successful else -1 MoveSwitch failed
     */
    @Override
    public int doAction(int[] userInput) {
        //System.out.println("In move switch");//*refactoring
        Worker floatingWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        Cell floatingCell = super.getExecutorPointer().getPrevSelect().getSelectedWorker().getCurrentPosition();
        int index;
        if(getExecutorPointer().getPrevSelect().getSelectedWorker() == getExecutorPointer().getCurrentPlayer().getFirstWorker())
            index= 0;
        else index = 1;

        if (super.doAction(userInput) == -1) {
            /* Do not call pointerBack(): it has already been called in the superclass */
            /* getFailedActionListener().actionFailed(new FailedActionEvent(this)); */
            return -1;
        }
        if (floatingWorker == null) {
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1; /* [NOTIFY]: MoveSwitch successful */
        } else if (super.getAvailableCells(index).contains(super.getExecutorPointer().getMap()[userInput[0]][userInput[1]])) {
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
