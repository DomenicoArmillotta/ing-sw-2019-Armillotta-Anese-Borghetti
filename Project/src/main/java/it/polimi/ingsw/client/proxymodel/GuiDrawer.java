package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.ClientCell;

public class GuiDrawer extends Drawer {

    void setup(ClientCell[][] map) {};
    public void drawMap(ClientCell[][] map){};
    public void setSelectableCell(ClientCell[][] map,Coords[] selectableCoords){}; //colora le celle che potrebbero essere selezionate
    public void setMoveWorker(ClientCell[][] map,WorkerClient selectedWorker,Coords moveCell){};
    public void setBuild(ClientCell[][] map,Coords buildCell,int levelToBuild){};
    public void drawSelectWorker(ClientCell[][] map,Coords selectCell){};
    public void drawWinGame(){};
    public void drawLooseGame(){};
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
}
