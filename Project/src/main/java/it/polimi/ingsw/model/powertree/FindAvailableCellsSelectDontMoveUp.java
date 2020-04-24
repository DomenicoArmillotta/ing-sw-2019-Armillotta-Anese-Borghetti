package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.Cell;
import it.polimi.ingsw.model.Level;

import java.util.ArrayList;
import java.util.List;

//in fase di sviluppo non funziona;

public class FindAvailableCellsSelectDontMoveUp extends FindAvailableCellsSelect{
    //atena è attiva e viene pushata alla testa
    @Override
    public int doAction(int[] userInput) {
       //non devo addare celle al massimo eliminarle
       List<Cell> tempCells= super.getExecutorPointer().getNextSelect().getAvailableCells();
       int i,j;
       int tempX,tempY;
       int h=0;
       Level currPlayerLevel;
       List<Cell> toRemoveCells = new ArrayList<>();
       boolean addable=false;

        while (h < tempCells.size()) {
            tempX = tempCells.get(h).getX();
            tempY = tempCells.get(h).getY();
            currPlayerLevel = tempCells.get(h).getWorkerOnCell().getCurrentPosition().getBuildingLevel();
            for (i = tempX - 1; i < tempX + 2 && !addable; i++) {
                for (j = tempY + 1; j > tempY - 2 && !addable; j--) {
                    if ((i >= 0 && i < 5) && (j >= 0 && j < 5)) {
                        if (super.getExecutorPointer().getMap()[i][j].getWorkerOnCell()==null && (super.getExecutorPointer().getMap()[i][j].getBuildingLevel().ordinal() - currPlayerLevel.ordinal() <= 0)){
                            addable = true;
                        }
                    }
                }
            }
            if(!addable){
                toRemoveCells.add(tempCells.get(h));
            }
            h++;
        }
        if(toRemoveCells.isEmpty()){
            System.out.println("chiamare la routine di perdita");
            return 0;
        }
        super.executorPointer.getNextSelect().removeCells(toRemoveCells);
        return 0;
    }
}
