package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;

public class SetupCoordsEvent extends CoordsEvent {
    int firstWorkerX;
    int firstWorkerY;
    int secondWorkerX;
    int secondWorkerY;

    public SetupCoordsEvent(int firstWorkerX, int firstWorkerY, int secondWorkerX, int secondWorkerY) {
        this.firstWorkerX = firstWorkerX;
        this.firstWorkerY = firstWorkerY;
        this.secondWorkerX = secondWorkerX;
        this.secondWorkerY = secondWorkerY;
    }

    public void serverEventMethod(Controller controller) {
        ActionExecutor.instance().getCurrentPlayer().workersSetup(firstWorkerX, firstWorkerY, secondWorkerX, secondWorkerY);
        int[] userInput = new int[2];
        userInput[0] = x;
        userInput[1] = y;
        controller.setUserInput(userInput);
        controller.control();
    }
}
