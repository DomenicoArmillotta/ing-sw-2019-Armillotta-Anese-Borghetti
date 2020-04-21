package it.polimi.ingsw;

import java.util.List;

public abstract class Power {
    int orderNumber;

    public int doAction(int[] userInput) {
        return -1;
    }

    ;
/*
    public void setAvailableCells(List<Cell> cellList) {
        ;
    };

    public List<Cell> getAvailableCells() {
        return null;
    }; */


   /* public void getOrderNumber() {
    }

    public void setOrderNumber() {
    }*/

    public ActionExecutor getExecutorPointer() {
        return executorPointer;
    }

    ActionExecutor executorPointer = ActionExecutor.instance();
}

/* public class ListElement {
    private List<SelectMove> selectMoveList;
    private List<Build> buildList;
    private List<WinCheck> winCheckList;
    private List<FindAvailableCells> findAvailableCellsList;
}
 */
