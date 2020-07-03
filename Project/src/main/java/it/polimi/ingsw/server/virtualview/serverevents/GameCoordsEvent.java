package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;
/**
 * this GameCoordsEvent was generated after the parser decoded the message received from the client and ActionExecutor
 * call the controller
 */
public class GameCoordsEvent extends ServerEvent {
    int x;
    int y;

    public GameCoordsEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void serverEventMethod(Controller controller) {
        int[] userInput = new int[2];
        userInput[0] = x;
        userInput[1] = y;
        controller.setUserInput(userInput);
        controller.control();
    }
}
