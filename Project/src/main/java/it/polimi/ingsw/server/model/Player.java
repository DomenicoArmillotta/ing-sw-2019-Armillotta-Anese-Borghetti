package it.polimi.ingsw.server.model;

import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.mvevents.eventbeans.CommandFailureEventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;

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

    /**
     * initializes both workers
     * @param firstX coord where I want to position my first worker
     * @param firstY coord where I want to position my first worker
     * @param secondX coord where I want to position my second worker
     * @param secondY coord where I want to position my second worker
     */
    public void workersSetup(int firstX, int firstY, int secondX, int secondY) {
        initFirstWorker(firstX, firstY);
        initSecondWorker(secondX, secondY);
    }
    /**
     *initialize the first worker by placing him on the map, making sure that the position is not already occupied.
     * @param x coord where I want to position my worker
     * @param y  coord where I want to position my worker
     */
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
            EventsBuffer.instance().setLastEventBean(new CommandFailureEventBean("cant place a worker here"));
        }
        firstWorker.setOwner(this);
    }

    /**
     *initialize the second worker by placing him on the map, making sure that the position is not already occupied.
     * @param x coord where I want to position my worker
     * @param y  coord where I want to position my worker
     */
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

    /**
     *remove both workers from the player
     */
    public void deleteWorkers(){
        this.firstWorker=null;
        this.secondWorker=null;
    }

}