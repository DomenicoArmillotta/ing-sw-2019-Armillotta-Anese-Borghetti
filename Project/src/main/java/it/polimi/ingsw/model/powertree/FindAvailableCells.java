package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

public class FindAvailableCells extends Power {

    public void loseCondition() {

        Player toDeletePlayer = getExecutorPointer().getCurrentPlayer();
        Player tempPlayer = super.getExecutorPointer().getPrevPlayer();
        if(!super.getExecutorPointer().getNextPlayer().equals(super.getExecutorPointer().getPrevPlayer())) {
            /*
            match da 3 persone,deve terminare il turno, settare l'ordine corretto dei player e eliminare il player che ha perso

            note-to-self: quando elimino il worker devo anche aggionare la cella su cui stavano
             */
            super.getExecutorPointer().nextTurn();

            super.getExecutorPointer().setPrevPlayer(tempPlayer);
            super.getExecutorPointer().setNextPlayer(tempPlayer);

            super.getExecutorPointer().getMap()[toDeletePlayer.getFirstWorker().getCurrentPosition().getX()][toDeletePlayer.getFirstWorker().getCurrentPosition().getY()].setWorkerOnCell(null);
            toDeletePlayer.getFirstWorker().removeWorker();
            super.getExecutorPointer().getMap()[toDeletePlayer.getSecondWorker().getPreviousPosition().getX()][toDeletePlayer.getSecondWorker().getPreviousPosition().getY()].setWorkerOnCell(null);
            toDeletePlayer.getSecondWorker().removeWorker();
            toDeletePlayer.deleteWorkers();
            return;
        }else{
            /*
            reset del game?? + scritta you win?
             */
            System.out.println("hai vinto "+super.getExecutorPointer().getNextPlayer().getName());
        }
    }

}
