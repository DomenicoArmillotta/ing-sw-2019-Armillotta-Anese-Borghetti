package it.polimi.ingsw.server.virtualview.network;

public class ServerStatus {
    boolean gameRunning;

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public boolean running() {
        return gameRunning;
    }
}
