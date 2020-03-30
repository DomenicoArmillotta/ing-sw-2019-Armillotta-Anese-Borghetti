package it.polimi.ingsw;

import java.util.*;

public class GameMaster {
    private Match match;
    private List<Player> playerQueue = new LinkedList(); //da controllora sinstassi
    private int numOfPlayer;

//ma c'è bisogno di una sala di attesa?

    public void createMatch(){
        if(numOfPlayer==2)
            match = new Match(player1,player2);
        else
            match = new Match(player1,player2,player3);
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
