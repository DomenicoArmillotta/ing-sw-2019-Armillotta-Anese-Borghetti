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
    ProxyModel proxyModel = ProxyModel.instance();
    /* aggiungere livello */

    public BuildBlockViewEvent(int blockX, int blockY, int levelToBuild) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.levelToBuild = levelToBuild;
    }

    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().setBuild(new Coords(blockX,blockY),levelToBuild);
        //proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        proxyModel.getDrawerStrategy().drawMap();
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getNextPlayer().getName() + "\u001B[0m" + " should select a worker typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed its "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    }
}
