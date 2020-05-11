package it.polimi.ingsw.server.virtualview.serverevents;

public class StringEvent extends ServerEvent {
    String userInput;
    public StringEvent(String userInput) {
        this.userInput = userInput;
    }
    public void serverEventMethod() {

    }
}
