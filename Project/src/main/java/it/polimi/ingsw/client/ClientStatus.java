package it.polimi.ingsw.client;

public class ClientStatus {
    boolean gameRunning;

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public boolean running() {
        return gameRunning;
    }
}
