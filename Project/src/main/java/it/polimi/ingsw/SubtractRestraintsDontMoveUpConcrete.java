package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class SubtractRestraintsDontMoveUpConcrete implements SubtractMoveRestraintsStrategy {
    @Override
    public List<Cell> doSubtractMoveRestraints(List<Cell> moveOptionsCells, Worker selectedWorker) {
        List<Cell> tempCells = new ArrayList<>();
        int h = 0;
        while(h<moveOptionsCells.size()){
            if (moveOptionsCells.get(h).getBuildingLevel().ordinal() <= selectedWorker.getCurrentLevel().ordinal()){
                tempCells.add(moveOptionsCells.get(h));
            }
            h++;
        }
        if(tempCells.size()==0){
            System.out.println("Sorry you loose please call a routine to finish this agony");
            return null;
        }
        return tempCells;
    }
}
