package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class SelectRestraintsDontMoveUpConcrete implements SubtractRestraintsStrategy {
    @Override
    public List<Cell> doSubtractRestraints(List<Cell> selectOptionsCells) {
        /*
        riceve in ingresso al più due celle e deve controllora che QUALSIASI CELLA NON SI
        > DEL CURR LEVEL DEL WORKER SELEZIONATO
         */
        List<Cell> tempCells = new ArrayList<>();
        int h = 0;
        int i,j;
        Level tempLevel;
        int tempX, tempY;
        int deltaLevel;
        Cell[][] tempMap = selectOptionsCells.get(0).getWorkerOnCell().getOwner().getCurrentMatch().getMap();
        boolean selectable=false;

        while (h<selectOptionsCells.size()) {
            tempLevel = selectOptionsCells.get(h).getBuildingLevel(); //prendo il livello del primo worker
            tempX = selectOptionsCells.get(h).getX();
            tempY = selectOptionsCells.get(h).getY();
            for (i = tempX - 1; i < tempX + 2; i++) {
                for (j = tempY + 1; j > tempY - 2; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        //ok, devo controllare che il DH sia < 0;
                        if (tempMap[i][j].getBuildingLevel().ordinal() <= selectOptionsCells.get(h).getBuildingLevel().ordinal()&& !selectable) {
                            if(tempMap[i][j].getWorkerOnCell()==null || tempMap[i][j].getWorkerOnCell().getOwner()!=selectOptionsCells.get(h).getWorkerOnCell().getOwner()) {
                                selectable=true;
                                System.out.println("diocane");
                            }
                        }
                    }
                }
            }
            if(selectable==true) {
                tempCells.add(selectOptionsCells.get(h));
                selectable = false;
            }h++;
        }
        return tempCells;
    }
}
