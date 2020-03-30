package it.polimi.ingsw;
public class Player {
    private char[] playerName;
    private char[] networkAddress;
    private GodCard playerGod;
    private Worker firstWorker;
    private Worker secondWorker;
    private Match currentMatch;

    public void setName(char[] playerName) {
        this.playerName = playerName;
    }

    public void setNetAddress(char[] networkAddress) {
        this.networkAddress = networkAddress;
    }

    public void setPlayerGod(GodCard playerGod) {
        this.playerGod = playerGod;
    }

    public void setFirstWorker(int x, int y) {
        Worker firstWorker = new Worker(this, (((this.getMatch()).getMap()).getCell(x,y)), (((this.getMatch()).getMap()).getCell(x,y)), GROUND, GROUND);
        this.firstWorker = firstWorker;
    }

    public void setSecondWorker(int x, int y) {
        Worker secondWorker = new Worker(this, (((this.getMatch()).getMap()).getCell(x,y)), (((this.getMatch()).getMap()).getCell(x,y)), GROUND, GROUND);
        this.secondWorker = secondWorker;
    }

    public Worker getFirstWorker() {
        return firstWorker;
    }

    public Worker getSecondWorker() {
        return secondWorker;
    }

    public char[] getName() {
        return playerName;
    }

    public char[] getNetAddress() {
        return networkAddress;
    }

    public GodCard getPlayerGod() {
        return playerGod;
    }

    public Match getMatch() {
        return currentMatch;
    }
}