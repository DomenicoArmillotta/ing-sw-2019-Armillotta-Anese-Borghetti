package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;

/**
 *this function checks if it is possible to make a move, checking the correctness
 * it is used by all gods
 */
public class MoveCheckingLevel extends Move {
    /**
     *this method checks if it is possible to make a move,
     *so,if the difference in level between the cell in which I am and the cell in which I want to move, is equal to 1
     * @param userInput cell where i want to move
     * @return 1  MoveCheckingLevel successful else -1 MoveCheckingLevel failed
     */
    @Override
    public int doAction(int[] userInput) {

        /* removeMalusMoveUpEffects(); */
        getExecutorPointer().getNextPlayer().getPlayerGod().getMoveLimitationsList().clear();
        getExecutorPointer().getPrevPlayer().getPlayerGod().getMoveLimitationsList().clear();

        if (super.doAction(userInput) == -1) {
            return -1;
        }

        Worker movedWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        if (movedWorker.getCurrentPosition().getBuildingLevel().ordinal() - movedWorker.getPreviousPosition().getBuildingLevel().ordinal() == 1) {
            getExecutorPointer().getNextPlayer().getPlayerGod().addMoveLimitations(new FindAvailableCellsMoveButDontMoveUp());
            getExecutorPointer().getPrevPlayer().getPlayerGod().addMoveLimitations(new FindAvailableCellsMoveButDontMoveUp());
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1;
        }
        getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
        return 1;
    }

}
