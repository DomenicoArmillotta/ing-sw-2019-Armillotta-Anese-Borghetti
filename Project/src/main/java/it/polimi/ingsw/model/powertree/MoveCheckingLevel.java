package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;
import java.util.List;

public class MoveCheckingLevel extends Move{
    /*voglio fare una copia della powerList e scorrerla fin che non trovo la move e quindi tornare indietro
    di un passo*/
    private void computeInjectionPowerIndex(Player player){
        List<Power> cachedPowerList = player.getPlayerGod().getPowerList();
        Power injectionPtr;
        Power selectListPtr = player.getPlayerGod().getSelectList().get(0);
        injectionPtr = player.getPlayerGod().getFindAvailableCellsList().get(0);
        int i;

        for(i=0 ; cachedPowerList.get(i)!= selectListPtr; i++){
            ;
        }
        player.getPlayerGod().getFindAvailableCellsList().add(i,new FindAvailableCellsMoveButDontMoveUp());
        cachedPowerList.add(i,new FindAvailableCellsMoveButDontMoveUp());
        //ho aggiornato la list power ma non la FindAvailableCells list;
        player.getPlayerGod().setPowerList(cachedPowerList);

    }

    @Override
    public int doAction(int[] userInput) {
        super.doAction(userInput);
        /*
        devo computare il changing di startegy
         */
        Worker movedWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        if(movedWorker.getCurrentPosition().getBuildingLevel().ordinal() - movedWorker.getPreviousPosition().getBuildingLevel().ordinal() == 1){
            computeInjectionPowerIndex(super.getExecutorPointer().getNextPlayer());
            computeInjectionPowerIndex(super.getExecutorPointer().getPrevPlayer());
            return 0;
        }
        return 0;
    }
}
