package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.server.model.ActionExecutor;

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
}