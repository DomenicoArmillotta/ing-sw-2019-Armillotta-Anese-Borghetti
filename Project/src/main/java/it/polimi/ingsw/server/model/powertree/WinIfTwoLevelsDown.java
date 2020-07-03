package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;
/**
 * This is Pan's winCondition
 */
public class WinIfTwoLevelsDown extends WinCondition{
    /**
     * the player who has the god with this win condition and moves between two cells and these two cells have difference equal to two then wins
     * @param userInput contains null;
     * @return 0 if player won else 1 to go on with the game
     */
    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        super.doAction(userInput);
        if ((selectedWorker.getPreviousPosition().getBuildingLevel().ordinal() - selectedWorker.getCurrentPosition().getBuildingLevel().ordinal()) == 2) {
            getPlayerWonListener().winGame(new PlayerWonEvent(super.getExecutorPointer().getCurrentPlayer()));
            return 0;
        } else {
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1;
        }
    }

}
