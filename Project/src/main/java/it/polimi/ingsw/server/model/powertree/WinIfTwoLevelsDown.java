package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;

/* This is Pan's winCondition */
public class WinIfTwoLevelsDown extends WinCondition{

    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        super.doAction(userInput);
        if ((selectedWorker.getPreviousPosition().getBuildingLevel().ordinal() - selectedWorker.getCurrentPosition().getBuildingLevel().ordinal()) == 2) {
            getPlayerWonListener().winGame(new PlayerWonEvent(super.getExecutorPointer().getCurrentPlayer()));
            return 0;
        } else {
            getFailedActionListener().actionFailed(new FailedActionEvent(this));
            return 1;
        }
    }

}
