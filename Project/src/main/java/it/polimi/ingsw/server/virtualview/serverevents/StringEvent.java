package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;

public class StringEvent extends ServerEvent {
    String userInput;
    public StringEvent(String userInput) {
        this.userInput = userInput;
    }
    public void serverEventMethod(Controller controller) {

    }
}
