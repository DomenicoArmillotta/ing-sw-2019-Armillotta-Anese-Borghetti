package it.polimi.ingsw;

import java.util.*;

public class GameMaster {
    private List<Player> playerQueue = new ArrayList(); //da controllora sinstassi
    private int numOfPlayers;
    private ActionExecutor actionExecutor;
    private List<GodCard> godList= new ArrayList<GodCard>();

    public GameMaster(int numOfPlayers, List<Player> playerQueue){
        this.numOfPlayers = numOfPlayers;
        this.playerQueue = playerQueue;
    }

    public void createActionExecutor(String playerQueue) {
       this.actionExecutor = new ActionExecutor(playerQueue);
    }

    public ActionExecutor getActionExecutor(){
        return this.actionExecutor;
    }

    public int getNumOfPlayers(){
        return this.numOfPlayers;
    }

    public List<Player> getPlayerQueue() {
        return playerQueue;
    }

    public void createGodList(){
        //la riempio
    }
    public void startActionExecutor(String playerQueue){
        this.actionExecutor.setup(playerQueue);
    }
}
