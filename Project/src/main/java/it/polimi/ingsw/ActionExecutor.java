package it.polimi.ingsw;

import jdk.nashorn.internal.runtime.doubleconv.CachedPowers;

import java.util.*;

public class ActionExecutor {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;
    private List<Power> powerList;
    private Power listPointer;
    private Cell[][] map;

    public ActionExecutor(List<Player> playersQueue) {
        if (playersQueue.size() == 2) {
            this.currentPlayer = playersQueue.get(0);
            this.nextPlayer = playersQueue.get(1);
            this.prevPlayer = playersQueue.get(1);
        } else if (playersQueue.size() == 3) {
            this.currentPlayer = playersQueue.get(0);
            this.nextPlayer = playersQueue.get(1);
            this.prevPlayer = playersQueue.get(2);
        }
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public Player getPrevPlayer() {
        return prevPlayer;
    }

    public void nextTurn() {
        Player tempPlayer = currentPlayer;
        currentPlayer = nextPlayer;
        prevPlayer = tempPlayer;
        nextPlayer = prevPlayer;
    }

    public Power getNextPower() {

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
        currentPlayer.setFirstWorker(firstWorker);
    }

    public void initSecondWorker(int x, int y) {
        Worker secondWorker = new Worker(map[x][y]);
        currentPlayer.setSecondWorker(secondWorker);
    }

}
