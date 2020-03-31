package it.polimi.ingsw;
public class Player {
    private String playerName;
    private String networkAddress;
    private GodCard playerGod;
    private Worker firstWorker;
    private Worker secondWorker;
    private Match currentMatch;

    //enumerazioni vedere teproa
    //modificare l'uml di first,second e choose
    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public void setNetAddress(String networkAddress) {
        this.networkAddress = networkAddress;
    }

    public void choosePlayerGod(String godName) {
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

    public String getName() {
        return playerName;
    }

    public String getNetAddress() {
        return networkAddress;
    }

    public GodCard getPlayerGod() {
        return playerGod;
    }

    public Match getMatch() {
        return currentMatch;
    }
}