package it.polimi.ingsw.server.model.powertree;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.Level;
import it.polimi.ingsw.server.model.Worker;
import java.util.ArrayList;
import java.util.List;

/**
 * it is used to create a list with the cells in which the selected worker can move
 */
public class FindAvailableCellsMove extends FindAvailableCells {
    /**
     * it is used to create a list with the cells in which the selected worker can move,
     * all adjacent cells are checked and checking if there is another worker on the cell,
     * if there is a dome, if the difference is greater than one
     * @param userInput
     * @return
     */
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


            int i, j, x, y, check;


            x = selectedWorker.getCurrentPosition().getX();
            y = selectedWorker.getCurrentPosition().getY();

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
            return 1;
        }

        if(!getExecutorPointer().getCurrentPlayer().getPlayerGod().getMoveLimitationsList().isEmpty())
            executeMoveLimitations();

        return 0;
    }

}





