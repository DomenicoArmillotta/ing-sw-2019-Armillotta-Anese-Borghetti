package it.polimi.ingsw;

import java.util.ArrayList;

public class Match {
    private ArrayList<Player> playersOrder;
    private Turn currentTurn;
    private Map matchMap;
    private GameMaster gameMaster;

    public Match(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        startFirstTurn(playersOrder);
    }

    public GameMaster getGameMaster() {
        return gameMaster;
    }

    public void setPlayersOrder(ArrayList<Player> playersQueue) {
        this.playersOrder = playersQueue;
    }

    public ArrayList<Player> getPlayersOrder() {
        return playersOrder;
    }

    public void startFirstTurn(ArrayList<Player> playersOrder) {
        this.currentTurn = new Turn(this, playersOrder);
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
