package it.polimi.ingsw.server.virtualview.network;

import java.util.ArrayList;
import java.util.List;

public class VvLobby {
    private List<String> players;
    private String partyOwner;

    private static VvLobby instance;

    public List<String> getPlayers() {
        return players;
    }

    public static VvLobby instance(){
        if(instance == null) {
            instance = new VvLobby();
        }return instance;
    }

    private VvLobby() {
        this.players = new ArrayList<>();
    }

    public void setPlayer(String player) {
        this.players.add(player);
    }

    public String getPartyOwner() {
        return partyOwner;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }
}