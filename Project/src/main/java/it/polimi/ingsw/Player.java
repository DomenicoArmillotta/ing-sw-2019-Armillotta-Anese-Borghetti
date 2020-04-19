package it.polimi.ingsw;
import java.util.*;

public class Player {
    private String playerName;
    private String networkAddress;
    private GodCard playerGod;
    private Worker firstWorker;
    private Worker secondWorker;

    public Player(String playerName)
    {
        this.playerName=playerName;
    }

    public void setNetAddress(String networkAddress) {
        this.networkAddress = networkAddress;
    }
    public void setPlayerGod(GodCard playerGod) {
        this.playerGod = playerGod;
    }
    public GodCard getPlayerGod() {
        return playerGod;
    }

    public String getName() {
        return playerName;
    }

    public String getNetAddress() {
        return networkAddress;
    }

    public Worker getFirstWorker() {
        return firstWorker;
    }

    public Worker getSecondWorker() {
        return secondWorker;
    }






}