package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.mvevents.actionevents.FailedActionEvent;
import it.polimi.ingsw.server.model.mvevents.actionevents.WaitingForActionEvent;

import java.util.ArrayList;
import java.util.List;


public class FindAvailableCellsMove extends FindAvailableCells {

    @Override
    public int doAction(int[] userInput) {

        Cell[][] map = super.getExecutorPointer().getMap();
        Worker selectedWorker;
        /* Reinizializza le celle rimovibili */
        super.getExecutorPointer().getNextMove().clearPower();

        for (int index = 0; index < 2; index++) {
            if (index == 0) selectedWorker = getExecutorPointer().getCurrentPlayer().getFirstWorker();
            else selectedWorker = getExecutorPointer().getCurrentPlayer().getSecondWorker();

            List<Cell> moveCells = new ArrayList<>();

            /* Worker selectedWorker=super.getExecutorPointer().getPrevSelect().getSelectedWorker(); */

            int i, j, x, y, check;

            /* if (selectedWorker == null)
                return -1; */
            x = selectedWorker.getCurrentPosition().getX();
            y = selectedWorker.getCurrentPosition().getY();
            /* Aggiungere condizione del bordo inferiore */
            /* System.out.print("Celle calcolate == "); */

            for (i = x - 1; i < x + 2 && i < 5; i++) {
                for (j = y - 1; j < y + 2 && j < 5; j++) {
                    check = 1;
                    if (i < 0) i = 0;
                    if (j < 0) j = 0;
                    /* Se  c'è un worker sopra non  aggiungo nella lista */
                    if (map[i][j].getWorkerOnCell() != null && check == 1) {
                        check = 0;
                    }
                    /* Se  c'è una cupola non  aggiungo nella lista */
                    if (map[i][j].getBuildingLevel() == Level.DOME && check == 1) {
                        check = 0;

                    }
                    /* Se la differenza è maggiore di 1 non aggiungo nella lista */
                    if ((selectedWorker.getCurrentPosition().getBuildingLevel().ordinal() - map[i][j].getBuildingLevel().ordinal()) < -1 && check == 1) {

                        check = 0;

                    }
                    if (check == 1) {
                        /* Inserisce nella lista */
                        moveCells.add(map[i][j]);
                        if(index==0) {
                        }

                    }
                }
            }
            super.getExecutorPointer().getNextMove().setAvailableCells(moveCells, index);
        }
        if (super.getExecutorPointer().getNextMove().getAvailableCells(0).isEmpty() && super.getExecutorPointer().getNextMove().getAvailableCells(1).isEmpty()) {
            super.loseCondition();
            return 1; /* [NOTIFY]: FindAvailableCellsMove failed */
        }

        if(!getExecutorPointer().getCurrentPlayer().getPlayerGod().getMoveLimitationsList().isEmpty())
            executeMoveLimitations();

        return 0; /* [NOTIFY]: FindAvailableCellsMove done */
    }

}





