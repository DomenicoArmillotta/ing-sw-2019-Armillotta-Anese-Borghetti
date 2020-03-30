package it.polimi.ingsw;
public class Player {
    private char[] playerName;
    private char[] networkAddress;
    private GodCard playerGod;
    private Worker firstWorker;
    private Worker secondWorker;
    private Match currentMatch;
    //stringa playerName e net
    //enumerazioni vedere teproa
    //modificare uml first,second e choose
    public void setName(char[] playerName) {
        this.playerName = playerName;
    }

    public void setNetAddress(char[] networkAddress) {
        this.networkAddress = networkAddress;
    }

    public void choosePlayerGod(char[] godName) {
        GodCard playerGod= new GodCard(godName,this);
        this.playerGod = playerGod;
    }

    public void initFirstWorker(int x, int y) {
        Worker firstWorker = new Worker(this, (((this.getMatch()).getMap()).getCell(x,y)), (((this.getMatch()).getMap()).getCell(x,y)), GROUND, GROUND);
        this.firstWorker = firstWorker;
    }

    public void initSecondWorker(int x, int y) {
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