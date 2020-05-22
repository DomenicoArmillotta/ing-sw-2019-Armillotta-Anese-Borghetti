package it.polimi.ingsw.client;

public class ClientStatus {
    private GamePhase gamePhase;
    private String thisClientNickname;
    private String partyOwner;

    private static ClientStatus instance;

    public static ClientStatus instance() {
        if (instance == null) {
            instance = new ClientStatus();
        }
        return instance;
    }

    private ClientStatus() {
        setThisClientNickname("");
        setPartyOwner("");
    }

    public GamePhase getGamePhase() {
        return gamePhase;
    }

    public String getThisClientNickname() {
        return thisClientNickname;
    }

    public String getPartyOwner() {
        return partyOwner;
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }

    public void setThisClientNickname(String thisClientNickname) {
        this.thisClientNickname = thisClientNickname;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }
}
