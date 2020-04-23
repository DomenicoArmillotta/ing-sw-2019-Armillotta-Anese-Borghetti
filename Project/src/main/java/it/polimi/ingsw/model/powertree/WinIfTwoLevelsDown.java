package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Level;
import it.polimi.ingsw.model.Worker;

//pan super.doaction
public class WinIfTwoLevelsDown extends WinCondition{
    @Override
    public int doAction(int[] userInput) {
        Worker selectedWorker = super.getExecutorPointer().getPrevSelect().getSelectedWorker();
        super.doAction(userInput);
        if((selectedWorker.getPreviousPosition().getBuildingLevel().ordinal()-selectedWorker.getCurrentPosition().getBuildingLevel().ordinal())==2  ){
            return 0;
        }else
            return -1;
    }
}
