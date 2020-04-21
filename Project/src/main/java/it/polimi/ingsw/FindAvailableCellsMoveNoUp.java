package it.polimi.ingsw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMoveNoUp extends FindAvailableCellsMove {
    public int doAction(int[] userInput) {
        Cell[][] map= super.getExecutorPointer().getMap();
        List<Cell> moveCells= super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).getAvailableCells();
        Worker selectedWorker=super.getSelectedWorker();

        int i, j, x, y, check;

        x = selectedWorker.getCurrentPosition().getX();
        y = selectedWorker.getCurrentPosition().getY();
        for (i = x - 1; i < x + 2 && i < 5; i++) {
            for (j = y - 1; j < y + 2 && j < 5; j++) {
                check = 1;
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                //se il livello è piu alto di quello corrente elimino
                if((selectedWorker.getCurrentPosition().getBuildingLevel().ordinal()-map[i][j].getBuildingLevel().ordinal())!=0 && check == 1)
                {

                    moveCells.remove(map[i][j]);
                }

            }
        }
        super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(moveCells);
        return 0;

    }
}
