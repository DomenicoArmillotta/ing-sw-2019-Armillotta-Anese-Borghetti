package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.virtualview.network.VvLobby;

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
    public  int loginControl(String nickName){
        VvLobby vvLobby = VvLobby.instance();
        if(vvLobby.getPlayers().isEmpty()) {
            vvLobby.setPartyOwner(nickName);
            vvLobby.setPlayer(nickName);
            return 1;
            /*il nick è gia preso */
        }else
        if(vvLobby.getPlayers().contains(nickName))
            return 0;
        else {
            vvLobby.setPlayer(nickName);
            return -1;
        }
    }
}