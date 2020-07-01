package it.polimi.ingsw.client;


public class StartUpEvent extends ClientEvent {
    String playerComm;
    String numberOfPlayers;

    public StartUpEvent(String playerComm, String numberOfPlayers) {
        this.playerComm = playerComm;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getPlayerComm() {
        return playerComm;
    }

    public void setPlayerComm(String playerComm) {
        this.playerComm = playerComm;
    }
}
