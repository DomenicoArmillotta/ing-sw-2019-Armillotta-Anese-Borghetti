package it.polimi.ingsw;

import java.util.*;

public class GameMaster {
        private Match match;
        private List<Player> playerQueue = new ArrayList(); //da controllora sinstassi
        private int numOfPlayers;


        public GameMaster(int numOfPlayers, List<Player> playerQueue){
            this.numOfPlayers = numOfPlayers;
            this.playerQueue = playerQueue;
        }

    public void createMatch() {

        this.match = new Match(this, playerQueue);
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

    public int getNumOfPlayers(){
        return this.numOfPlayers;
    }

    public List<Player> getPlayerQueue() {
        return playerQueue;
    }
}
