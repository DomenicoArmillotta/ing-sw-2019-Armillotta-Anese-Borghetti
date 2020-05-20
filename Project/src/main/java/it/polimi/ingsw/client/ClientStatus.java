package it.polimi.ingsw.client;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

import java.util.ArrayList;
import java.util.List;

public class ClientStatus {
    boolean gameRunning;
    String clientID;
    String currentPlayer;
    String whoAmI;

    private static ClientStatus instance;

    public static ClientStatus instance() {
        if (instance == null) {
            instance = new ClientStatus();
        }
        return instance;
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean running() {
        return gameRunning;
    }

    public void setWhoAmI(String whoAmI) {
        this.whoAmI = whoAmI;
    }

    public String getWhoAmI() {
        return whoAmI;
    }
}
