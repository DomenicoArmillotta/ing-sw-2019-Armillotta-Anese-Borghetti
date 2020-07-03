package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerLostEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;

import java.util.List;

/**
 * is a prototype of findAvailableCells contains as methods ExecuteMoveLimitation,LoseCondition
 */

public class FindAvailableCells extends Power {

    /**
     * executeMoveLimitation search through current player godCard and apply all malus effect that other gods
     * imposed on his god.
     * if moveLimitationLists  isn't empty, execute all the methods doAction() contained in the list else go on;
     */
    protected void executeMoveLimitations() {
        List<FindAvailableCells> moveLimitationsList = getExecutorPointer().getCurrentPlayer().getPlayerGod().getMoveLimitationsList();
        int result;
        boolean lost;
        lost = false;
        for(int i = 0; i < moveLimitationsList.size() && !lost; i++) {
            result = moveLimitationsList.get(i).doAction(null);
            if(result == -1) {
                loseCondition();//*refactor
                lost = true;
                //getFailedActionListener().actionFailed(new FailedActionEvent(moveLimitationsList.get(i))); *refactor
            }
        }
        /* moveLimitationsList.clear(); */
    }

    /**
     * method called by all classes of FindAvailableCells family, if(prev Player == next player) send win event and who won
     * else removes workers of the player who lost and notify the others with playerLostEvent
     */
    public void loseCondition() {
        Player toDeletePlayer = getExecutorPointer().getCurrentPlayer();
        Player tempPlayer = super.getExecutorPointer().getPrevPlayer();
        if (!super.getExecutorPointer().getNextPlayer().equals(super.getExecutorPointer().getPrevPlayer())) {

            super.getExecutorPointer().nextTurn();
            super.getExecutorPointer().setPrevPlayer(tempPlayer);
            super.getExecutorPointer().setNextPlayer(tempPlayer);
            /*
            vediamo se cossì funzia
             */
            //uno dei due dovrebbe andare, ora bisogna capire quale;
            getExecutorPointer().setPowerPtr(getExecutorPointer().getCurrentPlayer().getPlayerGod().getPowerList().get(0));
            //getExecutorPointer().setPowerPtr(null);
            super.getExecutorPointer().getMap()[toDeletePlayer.getFirstWorker().getCurrentPosition().getX()][toDeletePlayer.getFirstWorker().getCurrentPosition().getY()].setWorkerOnCell(null);
            toDeletePlayer.getFirstWorker().removeWorker();
            super.getExecutorPointer().getMap()[toDeletePlayer.getSecondWorker().getPreviousPosition().getX()][toDeletePlayer.getSecondWorker().getPreviousPosition().getY()].setWorkerOnCell(null);
            toDeletePlayer.getSecondWorker().removeWorker();
            toDeletePlayer.deleteWorkers();
            /*
            creare una funzione che refrasha la mappa dopo che uno perde
             */
            getPlayerLostListener().loseGame(new PlayerLostEvent(toDeletePlayer));

        } else {
            getPlayerWonListener().winGame(new PlayerWonEvent(getExecutorPointer().getCurrentPlayer()));
        }
    }

}
