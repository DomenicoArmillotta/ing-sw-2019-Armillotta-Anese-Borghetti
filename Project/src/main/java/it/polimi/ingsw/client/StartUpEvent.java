package it.polimi.ingsw.client;

public class StartUpEvent {
    String playerComm;

    public StartUpEvent(String playerComm) {
        this.playerComm = playerComm;
    }

    public String getPlayerComm() {
        return playerComm;
    }

    public void setPlayerComm(String playerComm) {
        this.playerComm = playerComm;
    }
}