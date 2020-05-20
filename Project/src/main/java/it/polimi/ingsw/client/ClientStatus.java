package it.polimi.ingsw.client;

public class ClientStatus {
    boolean gameRunning;
    String clientID;
    String currentPlayer;
    String whoAmI;
    String partyOwner;

    private static ClientStatus instance;

    public static ClientStatus instance() {
        if (instance == null) {
            instance = new ClientStatus();
        }
        return instance;
    }

    private ClientStatus() {
        whoAmI = null;
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

    public String getPartyOwner() {
        return partyOwner;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }
}
