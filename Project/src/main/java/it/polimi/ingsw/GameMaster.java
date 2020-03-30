package it.polimi.ingsw;

import java.util.*;

public class GameMaster {
    private Match match;
    private ArrayList<Player> playerQueue = new ArrayList(); //da controllora sinstassi
    private int numOfPlayer;

//ma c'è bisogno di una sala di attesa?
//sento gli altri

    public void createMatch() {
        this.match = new Match();
        this.match.setPlayersOrder(playerQueue);
    }

    public void setPlayerQueue(Player[] loginPlayerList){
        int il = 0;
        while(loginPlayerList[il]!=null){
            this.playerQueue.add(loginPlayerList[il]);
            il++;
        }
    }

    public Match getMatch(){
        return this.match;
    }

    public void freeQueue(){
        this.playerQueue.clear();
        //per la pulizia ci penserà il garbage-collector
    }
}
