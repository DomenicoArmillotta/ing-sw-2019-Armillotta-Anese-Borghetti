package it.polimi.ingsw;
/*
private char[] playerName;
private char[] networkAddress;
private GodCard playerGod;
private Worker[2] playerWorkers;
private Match currentMatch;
public void setPlayerName(char[] );
public void setNetworkAddress(char[] );
public void setPlayerGod(GodCard );
public void setMatch(Match );
public void setPlayerWorkers (int ,int ,int ,int  );
public Worker getPlayerWorkers ();
public char[] getPlayerName();
public char[] getNetworkAddress();
public GodCard getPlayerGod();
public Match getMatch();
 */

public class Player {
    private char[] playerName;
    private char[] networkAddress;
    private GodCard playerGod;
    private Worker[2] playerWorkers;
    private Match currentMatch;

    public void setPlayerName(char[] playerName) {
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

    public void setPlayerWorkers(int firstWorkerX, int firstWorkerY, int secondWorkerX, int secondWorkerY) {

    }

    public Worker getPlayerWorkers() {
        return null;
    }

    public char[] getPlayerName() {
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
}
