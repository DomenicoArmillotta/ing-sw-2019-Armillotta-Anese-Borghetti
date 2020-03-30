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

    public void setNetworkAddress(char[] networkAddress) {
        this.networkAddress = networkAddress;
    }

    public void setPlayerGod(GodCard playerGod) {
        this.playerGod = playerGod;
    }

    public void setMatch(Match currentMatch) {
        this.currentMatch = currentMatch;
    }

    //setto le cordinate iniziali
    public void setFirstWorkers(int firstWorkerX, int firstWorkerY) {
        Worker worker1=new Worker();
        Cell workerCell = getCell(firstWorkerX,firstWorkerY);
        worker1.setCurrentPosition(workerCell);
        worker1.setOwner(this);
        


    }


    public void setSecondWorkers( int secondWorkerX, int secondWorkerY) {

    }

    public char[] getName() {
        return playerName;
    }

    public char[] getNetworkAddress() {
        return networkAddress;
    }

    public GodCard getPlayerGod() {
        return playerGod;
    }

    public Match getMatch() {
        return currentMatch;
    }

    public Worker getFirstWorkers() {
            return null;
        }

    public Worker getSecondWorkers() {
            return null;
        }
}
