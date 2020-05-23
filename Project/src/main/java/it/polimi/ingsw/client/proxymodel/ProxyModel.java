package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.WorkerClient;
import it.polimi.ingsw.client.proxymodel.CliDrawer;
import it.polimi.ingsw.client.proxymodel.GuiDrawer;
import it.polimi.ingsw.client.proxymodel.ClientCell;

import java.util.ArrayList;
import java.util.List;
//quando si crea il proxy model,bisogna settare i turni e bisogna impostare nome dei giocatori

public class ProxyModel {

    private static ProxyModel instance;
    private List<Player> players=new ArrayList<>();
    private Turn turn;
    String thisClientNickname;
    String partyOwner;

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player playerToAdd){
        this.players.add(playerToAdd);
        System.out.println("aggiunto = "+ playerToAdd.getName());
    }

    public static ProxyModel instance() {

        if (instance == null) {
            instance = new ProxyModel();
            instance.createMap();
        }

        return instance;
    }

    private ProxyModel() {
        this.thisClientNickname = "";
        this.partyOwner = "";
    }

    public String getThisClientNickname() {
        return thisClientNickname;
    }
    public String getPartyOwner() {
        return partyOwner;
    }

    public void setThisClientNickname(String thisClientNickname) {
        this.thisClientNickname = thisClientNickname;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }

    private ClientCell[][] map;

    public Drawer getDrawerStrategy() {
        return drawerStrategy;
    }

    private ClientCell selectCell;
    private ClientCell moveCell;
    private ClientCell buildCell;
    private WorkerClient selectedWorker;
    private WorkerClient[] allWorker;
    //fare classe coordinate
    private Coords selectableCoords;  //vale per select,buil,move array a 3 dimensioni per le cordinate
    private Drawer drawerStrategy;


    public void setDrawerStrategy(Drawer drawerStrategy) {
        this.drawerStrategy = drawerStrategy;
    }
    public ClientCell[][] getMap() {
        return map;
    }



    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void createMap(){
        this.map=new ClientCell[7][7];
        int i,j;
        for(i=0;i<7;i++){
            for(j=0;j<7;j++) {
                map[i][j]=new ClientCell();
                }
            }
        this.map=map;

    }

    public Turn getTurn(){
        return this.turn;
    }

    public void createTurn(){
        this.turn = new Turn();
    }

}
