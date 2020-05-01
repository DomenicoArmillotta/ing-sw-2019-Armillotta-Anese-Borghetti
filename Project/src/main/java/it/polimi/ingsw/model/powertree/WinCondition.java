package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

/* Player wins if his Worker has gone up one level and is now at TOP level */
public class WinCondition extends Power {

    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        if ((selectedWorker.getPreviousPosition().getBuildingLevel().ordinal() - selectedWorker.getCurrentPosition().getBuildingLevel().ordinal()) == -1 && selectedWorker.getCurrentPosition().getBuildingLevel() == Level.TOP) {
            return 0;
        } else
            return -1;
    }

}
