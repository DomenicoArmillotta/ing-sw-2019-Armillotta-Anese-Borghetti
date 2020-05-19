package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;
import it.polimi.ingsw.server.model.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildBlockViewEvent extends ViewEvent {
    int blockX;
    int blockY;
    int levelToBuild;
    /* aggiungere livello */
    public BuildBlockViewEvent(int blockX, int blockY) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.levelToBuild=1;
    }
    public boolean startWaiting() {
        return false;
    }
    public void viewMethod(){
        Coords coords=new Coords(blockX,blockY);
        ProxyModel proxyModel=ProxyModel.instance();
        proxyModel.getDrawerStrategy().setBuild(proxyModel.getMap(),coords,levelToBuild);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"0","0","0");
    }

    public void viewEventMethod() {
        ProxyModel proxyModel = new ProxyModel();
        proxyModel.createMap();
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setBuild(proxyModel.getMap(),new Coords(blockX,blockY),levelToBuild);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"0","0","0");
    }
}
