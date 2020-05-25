package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.ClientCell;

import java.util.List;

public class GuiDrawer extends Drawer {

    public void setup() {};
    public void drawMap(Player player1,Player player2,Player player3){};
    public void setSelectableCell( List<Coords> selectableCoords,int value){}; //colora le celle che potrebbero essere selezionate
    public void setMoveWorker(WorkerClient selectedWorker,Coords moveCell){};
    public void setBuild(Coords buildCell,int levelToBuild){};
    public void setIsSelected(WorkerClient selectedWorker){};
    public void drawSelectWorker(Coords selectCell){};
    public void drawWinGame(){};
    public void drawLooseGame(){};
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
    public void createPlayer(String name){};
    public void createWorker1(Player player,Coords startCoords){};
    public void createWorker2(Player player,Coords startCoords){};
}
