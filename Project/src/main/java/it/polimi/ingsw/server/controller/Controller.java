package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.virtualview.network.VvLobby;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private int[] userInput;

    public void setUserInput(int[] userInput) {
        this.userInput = userInput;
    }

    public void control() {
        System.out.println("In controller");
        ActionExecutor executorPointer = ActionExecutor.instance();
        System.out.println(this.userInput[0]+" "+this.userInput[1]);
        int returnValue = executorPointer.getNextPower().doAction(this.userInput);
        System.out.println("Return value: "+returnValue);
        while(returnValue == 1) {
            returnValue = executorPointer.getNextPower().doAction(null);
            System.out.println("Return value: "+returnValue);
        }
    }

    public int loginControl(String nickName){
        VvLobby vvLobby = VvLobby.instance();
        if(vvLobby.getPlayers().isEmpty()) {
            vvLobby.setPartyOwner(nickName);
        }else
        if(!vvLobby.getPlayers().isEmpty() && vvLobby.getPlayers().contains(nickName))
            return 0;
        vvLobby.setPlayer(nickName);
        return 1;
    }

    public void startGameControl(){
        List<Player> toQueuePlayerList = new ArrayList<>();
        for (int i = 0; i < VvLobby.instance().getPlayers().size(); i++) {
            toQueuePlayerList.add(new Player(VvLobby.instance().getPlayers().get(i)));
        }
        GameMaster gameMaster = new GameMaster(toQueuePlayerList,VvLobby.instance().getPlayers().size());
        /*
        logica per creare il action executor, poi settiamo i players
         */
        //
    }
}