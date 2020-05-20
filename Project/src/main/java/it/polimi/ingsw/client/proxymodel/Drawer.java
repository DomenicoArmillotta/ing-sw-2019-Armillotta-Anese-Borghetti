package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.ClientCell;

import java.util.List;

public abstract class Drawer {

    void setup() {};
    public void drawMap(){};
    public void setSelectableCell( List<Coords> selectableCoords){}; //colora le celle che potrebbero essere selezionate
    public void setMoveWorker(Coords workerCoords,Coords moveCell){};
    public void setBuild(Coords buildCell,int levelToBuild){};
    public void drawSelectWorker(Coords selectCell){};
    public void drawWinGame(){};
    public void drawLooseGame(){};
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
}
