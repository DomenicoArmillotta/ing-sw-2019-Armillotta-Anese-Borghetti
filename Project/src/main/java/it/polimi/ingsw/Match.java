package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Player> playersOrder;
    private Turn currentTurn;
    private Map matchMap;
    private GameMaster gameMaster;
    private List<GodCard> godList = new ArrayList<GodCard>();

    public Match(GameMaster gameMaster, List<Player> playersQueue) {
        this.gameMaster = gameMaster;
        this.playersOrder = playersQueue;
        startFirstTurn(playersOrder);
    }

    /*creatore di godList*/

    public void createGodList(){
        GodCard apollo = new GodCard("Apollo");
        Effect effectApollo = new Effect();
        effectApollo.setEffectStrategies;
        godList.add(apollo);

    }


    public GameMaster getGameMaster() {
        return gameMaster;
    }

    public void setPlayersOrder(List<Player> playersQueue) {
        this.playersOrder = playersQueue;
    }

    public List<Player> getPlayersOrder() {
        return playersOrder;
    }

    public void startFirstTurn(List<Player> playersOrder) {
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
