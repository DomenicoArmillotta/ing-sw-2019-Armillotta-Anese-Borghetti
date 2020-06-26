package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

public class BuildBlockViewEvent extends ViewEvent {
    int blockX;
    int blockY;
    int levelToBuild;
    ProxyModel proxyModel = ProxyModel.instance();

    public BuildBlockViewEvent(int blockX, int blockY, int levelToBuild) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.levelToBuild = levelToBuild;
    }

    public void viewEventMethod() {
        proxyModel.setBuild(new Coords(blockX,blockY),levelToBuild);
        proxyModel.getDrawerStrategy().drawMap();
        proxyModel.getDrawerStrategy().promptSelectionText();
    }
}
