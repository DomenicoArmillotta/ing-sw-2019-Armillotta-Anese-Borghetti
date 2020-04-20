package it.polimi.ingsw;

import javax.swing.*;
import java.util.*;

public class ActionExecutor {
    private ActualTurn currentActualTurn;
    private ActualTurn nextActualTurn;
    private ActualTurn prevActualTurn;
    private List<Build> buildList;
    private List<SelectMove> selectMoveList;
    private List<FindAvailableCells> findAvailableCellsList;
    private List<WinCheck> winChecksList;
    private Power listPointer;
    private Cell[][] map;

    private static ActionExecutor instance;

    private ActionExecutor() {
    }

    public static ActionExecutor instance() {
        if (instance == null) {
            instance = new ActionExecutor();
        }
        return instance;
    }

    public Power getListPointer() {
        return listPointer;
    }

    public ActualTurn getCurrentActualTurn() {
        return currentActualTurn;
    }

    public ActualTurn getNextActualTurn() {
        return nextActualTurn;
    }

    public ActualTurn getPrevActualTurn() {
        return prevActualTurn;
    }

    public void setCurrentActualTurn(ActualTurn currentActualTurn) {
        this.currentActualTurn = currentActualTurn;
    }

    public void setNextActualTurn(ActualTurn nextActualTurn) {
        this.nextActualTurn = nextActualTurn;
    }

    public void setPrevActualTurn(ActualTurn prevActualTurn) {
        this.prevActualTurn = prevActualTurn;
    }

    public void nextTurn() {
        ActualTurn tempActualTurn = currentActualTurn;
        currentActualTurn = nextActualTurn;
        prevActualTurn = tempActualTurn;
        nextActualTurn = prevActualTurn;
    }

    public void appendPower(Power nextPower) {

    }

    public void createMap() {
        Cell[][] map = new Cell[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = new Cell();
                map[i][j].setX(i);
                map[i][j].setY(j);
            }
        }
        this.map = map;
    }

    public void setup(int firstWorkerX, int firstWorkerY, int secondWorkerX, int secondWorkerY) {
        createMap();
        initFirstWorker(firstWorkerX, firstWorkerY);
        initSecondWorker(secondWorkerX, secondWorkerY);
    }

    public Cell[][] getMap() {
        return map;
    }

    public void initFirstWorker(int x, int y) {
        Worker firstWorker = new Worker(map[x][y]);
        currentActualTurn.getPlayer().setFirstWorker(firstWorker);
    }

    public void initSecondWorker(int x, int y) {
        Worker secondWorker = new Worker(map[x][y]);
        currentActualTurn.getPlayer().setSecondWorker(secondWorker);
    }

}
