package it.polimi.ingsw.client;

public class ClientStatus {
    boolean gameRunning;
    String clientID;

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }

    public boolean running() {
        return gameRunning;
    }
}
