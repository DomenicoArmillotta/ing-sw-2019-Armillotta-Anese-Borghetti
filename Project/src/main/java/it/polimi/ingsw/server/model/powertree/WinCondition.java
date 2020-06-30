package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;

/* Player wins if his Worker has gone up one level and is now at TOP level */

/**
 * get selected worker of the current turn and verify thet win condition is verified : workers level went from
 * Mid to Top and notify win with PlayerWonEvent
 */
public class WinCondition extends Power {

    /**
     * @param userInput contains null;
     * @return 0 if won else 1 to continue autonomously;
     */
    @Override
    public int doAction(int[] userInput) {
        //System.out.println("In win check");//*refactor
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        if ((selectedWorker.getPreviousPosition().getBuildingLevel().ordinal() - selectedWorker.getCurrentPosition().getBuildingLevel().ordinal()) == -1 && selectedWorker.getCurrentPosition().getBuildingLevel() == Level.TOP) {
            getPlayerWonListener().winGame(new PlayerWonEvent(super.getExecutorPointer().getCurrentPlayer()));
            return 0;
        } else {
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1;
        }
    }

}
