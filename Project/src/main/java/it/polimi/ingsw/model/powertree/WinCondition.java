package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Level;
import it.polimi.ingsw.model.Worker;

//se mi trovo nella posizione top
public class WinCondition extends Power {
    @Override
    public int doAction(int[] userInput) {

        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        if((selectedWorker.getPreviousPosition().getBuildingLevel().ordinal()-selectedWorker.getCurrentPosition().getBuildingLevel().ordinal())==-1 && selectedWorker.getCurrentPosition().getBuildingLevel()== Level.TOP ){
            return 0;
        }else
            return -1;
    }
}
