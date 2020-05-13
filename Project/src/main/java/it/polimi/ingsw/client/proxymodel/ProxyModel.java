package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.WorkerClient;
import it.polimi.ingsw.client.proxymodel.CliDrawer;
import it.polimi.ingsw.client.proxymodel.GuiDrawer;

public class ProxyModel {
    //fare classe cella con tutti gli attributi tra cui selectable bbooleano,worker,livello,border
    private char[][] map;
    private int selectX;
    private int SelectY;
    private int moveX;
    private int moveY;
    private int buildX;
    private int buildY;
    private WorkerClient selectedWorker;
    private WorkerClient[] allWorker;
    //fare classe coordinate
    private int[][] selectableCell;  //vale per select,buil,move array a 3 dimensioni per le cordinate
    private Drawer drawerStrategy;

    public void setDrawerStrategy(Drawer drawerStrategy) {
        this.drawerStrategy = drawerStrategy;
    }

}
