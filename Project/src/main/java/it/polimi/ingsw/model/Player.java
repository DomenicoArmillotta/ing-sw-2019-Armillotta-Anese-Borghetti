package it.polimi.ingsw.model;

import it.polimi.ingsw.model.powertree.*;

public class Player {
    private String playerName;
    private String networkAddress;
    private GodCard playerGod;
    private Worker firstWorker;
    private Worker secondWorker;

    public Player(String playerName) {
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

    public void setFirstWorker(Worker firstWorker) {
        this.firstWorker = firstWorker;
    }

    public void setSecondWorker(Worker secondWorker) {
        this.secondWorker = secondWorker;
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

    public void workersSetup(int firstX, int firstY, int secondX, int secondY) {
        initFirstWorker(firstX, firstY);
        initSecondWorker(secondX, secondY);
    }

    public void initFirstWorker(int x, int y) {
        ActionExecutor actionExecutor = this.getPlayerGod().getFindAvailableCellsList().get(0).getExecutorPointer();
        Cell[][] map = actionExecutor.getMap();
        if (map[x][y].getWorkerOnCell() == null) {
            Worker firstWorker = new Worker(map[x][y]);
            this.setFirstWorker(firstWorker);
            map[x][y].setWorkerOnCell(firstWorker);
        } else {
            System.out.println("Cannot place " + this.playerName + "'s first Worker on cell " + x + " " + y);
            System.out.println("Cell " + x + " " + y + " is already occupied by " + map[x][y].getWorkerOnCell());
        }
        firstWorker.setOwner(this);
    }

    public void initSecondWorker(int x, int y) {
        ActionExecutor actionExecutor = this.getPlayerGod().getFindAvailableCellsList().get(0).getExecutorPointer();
        Cell[][] map = actionExecutor.getMap();
        if (map[x][y].getWorkerOnCell() == null) {
            Worker secondWorker = new Worker(map[x][y]);
            this.setSecondWorker(secondWorker);
            map[x][y].setWorkerOnCell(secondWorker);
        } else {
            /* error */
            System.out.println("Cannot place " + this.playerName + "'s second Worker on cell " + x + " " + y);
            System.out.println("Cell " + x + " " + y + " is already occupied by " + map[x][y].getWorkerOnCell());
        }
        secondWorker.setOwner(this);
    }
    public void deleteWorkers(){
        this.firstWorker=null;
        this.secondWorker=null;
    }

}