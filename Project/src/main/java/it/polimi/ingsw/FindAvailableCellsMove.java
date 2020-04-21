package it.polimi.ingsw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMove extends FindAvailableCells {
    public int doAction(int[] userInput) {
    List<Cell> moveCells=new ArrayList<>();
    Cell[][] map= super.getExecutorPointer().getMap();
    Worker selectedWorker=super.getSelectedWorker();

        int i, j, x, y, check;

        x = selectedWorker.getCurrentPosition().getX();
        y = selectedWorker.getCurrentPosition().getY();
        //aggiungere condizione del bordo inferiore
        System.out.print("Celle calcolate == ");

        for (i = x - 1; i < x + 2 && i < 5; i++) {
            for (j = y - 1; j < y + 2 && j < 5; j++) {
                check = 1;
                if (i < 0) i = 0;
                if (j < 0) j = 0;
                //se  c'è un operatore sopra non  aggiungo nella lista
                if (map[i][j].getWorkerOnCell() != null && check == 1) {
                    check = 0;
                }
                //se  c'è una cupola non  aggiungo nella lista
                if (map[i][j].getBuildingLevel() == Level.DOME && check == 1) {
                    check = 0;

                }
                //se la differenza è maggiore di 1 non aggiungo nella lista
                if((map[i][j].getBuildingLevel().ordinal()-selectedWorker.getCurrentPosition().getBuildingLevel().ordinal())>1 && check==1 ){

                    check=0;

                }
                if(check==1){
                    //inserisce nella lista
                    moveCells.add(map[i][j]);
                    System.out.print(map[i][j].getX());
                    System.out.print(map[i][j].getY());

                }
            }
        }
        super.getExecutorPointer().getCurrentActualTurn().getSelectMoveList().get(0).setAvailableCells(moveCells);
        return 0;

    }

}





