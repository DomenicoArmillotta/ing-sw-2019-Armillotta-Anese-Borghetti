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


    public void viewEventMethod() {
        ProxyModel.instance().getDrawerStrategy().setBuild(new Coords(this.blockX,this.blockY),levelToBuild);
        ProxyModel.instance().getDrawerStrategy().drawMap();
    }
}
