package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;

public class GameCoordsEvent extends CoordsEvent {

    public GameCoordsEvent(int x, int y) {
        super(x, y);
    }

    public void serverEventMethod(Controller controller) {
        int[] userInput = new int[2];
        userInput[0] = x;
        userInput[1] = y;
        controller.setUserInput(userInput);
        controller.control();
    }
}
