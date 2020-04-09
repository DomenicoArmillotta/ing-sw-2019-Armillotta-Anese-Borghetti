package it.polimi.ingsw;
import java.util.*;

public class Player {
    private String playerName;
    private String networkAddress;
    private GodCard playerGod;
    private Worker firstWorker;
    private Worker secondWorker;
    private Match currentMatch;

    public Player(String playerName)
    {
        this.playerName=playerName;
    }

    public void setNetAddress(String networkAddress) {
        this.networkAddress = networkAddress;
    }

    public void initFirstWorker(int x, int y) {
        Worker firstWorker = new Worker(this, (((this.getCurrentMatch()).getMap()[x][y])),   Level.GROUND);
        this.firstWorker = firstWorker;

    }
    public void initSecondWorker(int x, int y) {
        Worker secondWorker = new Worker(this,  (((this.getCurrentMatch()).getCell(x,y))),  Level.GROUND);
        this.secondWorker = secondWorker;
    }
    public void setPlayerGod(GodCard playerGod) {
        this.playerGod = playerGod;
    }
    public GodCard getPlayerGod() {
        return playerGod;
    }

    public void setCurrentMatch(Match currentMatch) {
        this.currentMatch = currentMatch;
    }
    public Match getCurrentMatch() {
        return currentMatch;
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