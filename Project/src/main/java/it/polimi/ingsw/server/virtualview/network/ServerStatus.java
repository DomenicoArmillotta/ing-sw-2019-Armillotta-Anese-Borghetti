package it.polimi.ingsw.server.virtualview.network;

public class ServerStatus {
    private GamePhase gamePhase;

    private static ServerStatus instance;

    public static ServerStatus instance() {
        if (instance == null) {
            instance = new ServerStatus();
        }
        return instance;
    }

    public GamePhase getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }

}
