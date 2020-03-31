package it.polimi.ingsw;

import java.util.ArrayList;

public class Match {
    private ArrayList<Player> playersOrder;
    private Turn currentTurn;
    private Map matchMap;

    public void setPlayersOrder(ArrayList<Player> playersQueue) {
        this.playersOrder = playersQueue;
    }

    public ArrayList<Player> getPlayersOrder() {
        return playersOrder;
    }

    public void startFirstTurn(ArrayList<Player> playersOrder) {
        this.currentTurn = new Turn();
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public void createMap() {
        this.matchMap = new Map();
    }

    public Map getMap() {
        return this.matchMap;
    }

}
