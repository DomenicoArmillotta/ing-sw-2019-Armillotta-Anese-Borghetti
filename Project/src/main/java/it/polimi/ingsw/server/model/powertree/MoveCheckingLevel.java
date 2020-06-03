package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.NoUpdatesEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WorkerMovementEvent;

import java.util.ArrayList;
import java.util.List;

/* dummyFindAvailableCellsDentMoveUp.equals(player.getPlayerGod().getFindAvailableCellsList().getClass().toString()) */

public class MoveCheckingLevel extends Move {

    /* Voglio fare una copia della powerList e scorrerla fin che non trovo la move e quindi tornare indietro di un passo */
    /*
    private void computeInjectionPowerIndex(Player player) {

        List<Power> cachedPowerList = player.getPlayerGod().getPowerList();
        Power injectionPtr;
        Power selectListPtr = player.getPlayerGod().getSelectList().get(0);
        injectionPtr = player.getPlayerGod().getFindAvailableCellsList().get(0);
        int i;

        for (i = 0; cachedPowerList.get(i) != selectListPtr; i++) {
            ;
        }
        player.getPlayerGod().getFindAvailableCellsList().add(i, new FindAvailableCellsMoveButDontMoveUp());
        cachedPowerList.add(i, player.getPlayerGod().getFindAvailableCellsList().get(i));
         Ho aggiornato la list power ma non la FindAvailableCells list;
        player.getPlayerGod().setPowerList(cachedPowerList);

    }

    private void removeMalusMoveUpEffects(){
        List<Player> playerList = new ArrayList<>();
        playerList.add(super.getExecutorPointer().getPrevPlayer());
        playerList.add(super.getExecutorPointer().getNextPlayer());
        boolean flaggable;
        int h;
        for (int i = 0; i < playerList.size(); i++) {
            h = 0;
            flaggable=false;
            while (playerList.get(i).getPlayerGod().getFindAvailableCellsList().size() > h && !flaggable) {
                if (playerList.get(i).getPlayerGod().getFindAvailableCellsList().get(h).getClass().equals(FindAvailableCellsMoveButDontMoveUp.class)) {
                    playerList.get(i).getPlayerGod().getFindAvailableCellsList().remove(h);
                    playerList.get(i).getPlayerGod().getPowerList().remove(h);
                    flaggable=true;
                }
                h++;
            }

        }
    } */

    @Override
    public int doAction(int[] userInput) {

        /* removeMalusMoveUpEffects(); */
        getExecutorPointer().getNextPlayer().getPlayerGod().getMoveLimitationsList().clear();
        getExecutorPointer().getPrevPlayer().getPlayerGod().getMoveLimitationsList().clear();

        if (super.doAction(userInput) == -1) {
            /* Do not call pointerBack(): it has already been called in the superclass */
            return -1;
        }

        /* Devo computare il changing di startegy */
        Worker movedWorker = super.getExecutorPointer().getMap()[userInput[0]][userInput[1]].getWorkerOnCell();
        if (movedWorker.getCurrentPosition().getBuildingLevel().ordinal() - movedWorker.getPreviousPosition().getBuildingLevel().ordinal() == 1) {
            getExecutorPointer().getNextPlayer().getPlayerGod().addMoveLimitations(new FindAvailableCellsMoveButDontMoveUp());
            getExecutorPointer().getPrevPlayer().getPlayerGod().addMoveLimitations(new FindAvailableCellsMoveButDontMoveUp());
            /* computeInjectionPowerIndex(super.getExecutorPointer().getNextPlayer());
            computeInjectionPowerIndex(super.getExecutorPointer().getPrevPlayer()); */
            //getWorkerMovementListener().workerMoved(new WorkerMovementEvent(movedWorker));
            getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
            return 1; /* [NOTIFY]: MoveCheckingLevel successful */

        }
        //getWorkerMovementListener().workerMoved(new WorkerMovementEvent(movedWorker));
        getNoUpdatesListener().noUpdates(new NoUpdatesEvent());
        return 1; /* [NOTIFY]: MoveCheckingLevel successful */
    }

}
