package it.polimi.ingsw.virtualview;

public class ServerStatus {
    boolean gameRunning;

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public boolean running() {
        return gameRunning;
    }
}
