package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.PlayerWonEvent;

import java.util.List;

public class FindAvailableCells extends Power {

    protected void executeMoveLimitations() {
        List<FindAvailableCells> moveLimitationsList = getExecutorPointer().getCurrentPlayer().getPlayerGod().getMoveLimitationsList();
        int result;
        boolean lost;
        lost = false;
        for(int i = 0; i < moveLimitationsList.size() && !lost; i++) {
            result = moveLimitationsList.get(i).doAction(null);
            if(result == -1) {
                lost = true;
                getFailedActionListener().actionFailed(new FailedActionEvent(moveLimitationsList.get(i)));
            }
        }
        /* moveLimitationsList.clear(); */
    }

    public void loseCondition() {

        Player toDeletePlayer = getExecutorPointer().getCurrentPlayer();
        Player tempPlayer = super.getExecutorPointer().getPrevPlayer();
        if (!super.getExecutorPointer().getNextPlayer().equals(super.getExecutorPointer().getPrevPlayer())) {
            /*
            match da 3 persone,deve terminare il turno, settare l'ordine corretto dei player e eliminare il player che ha perso

            note-to-self: quando elimino il worker devo anche aggionare la cella su cui stavano
             */
            super.getExecutorPointer().nextTurn();

            super.getExecutorPointer().setPrevPlayer(tempPlayer);
            super.getExecutorPointer().setNextPlayer(tempPlayer);

            getExecutorPointer().setPowerPtr(getExecutorPointer().getNextPlayer().getPlayerGod().getPowerList().get(0));
            //quando qualcuno perde viene tornato 1
            super.getExecutorPointer().getMap()[toDeletePlayer.getFirstWorker().getCurrentPosition().getX()][toDeletePlayer.getFirstWorker().getCurrentPosition().getY()].setWorkerOnCell(null);
            toDeletePlayer.getFirstWorker().removeWorker();
            super.getExecutorPointer().getMap()[toDeletePlayer.getSecondWorker().getPreviousPosition().getX()][toDeletePlayer.getSecondWorker().getPreviousPosition().getY()].setWorkerOnCell(null);
            toDeletePlayer.getSecondWorker().removeWorker();
            toDeletePlayer.deleteWorkers();
            return;
        } else {
            /*
             */
            getPlayerWonListener().winGame(new PlayerWonEvent(getExecutorPointer().getCurrentPlayer()));
            System.out.println("hai vinto " + super.getExecutorPointer().getNextPlayer().getName());
        }
    }

}
