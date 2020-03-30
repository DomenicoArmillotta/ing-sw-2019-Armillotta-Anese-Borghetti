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

    public Turn startFirstTurn(ArrayList<Player> playersOrder) {
        this.currentTurn = new Turn();
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public void createMap(void) {
        this.matchMap = new Map();
    }

    public getMap(void) {
        return this.matchMap;
    }

}
