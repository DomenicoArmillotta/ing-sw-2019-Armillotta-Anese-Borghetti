package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;
/**
 * it is used to draw the build block event, calling the functions for drawing
 */
public class BuildBlockViewEvent extends ViewEvent {
    int blockX;
    int blockY;
    int levelToBuild;
    ProxyModel proxyModel = ProxyModel.instance();

    /**
     * is the constructor
     * @param blockX block coord x
     * @param blockY block coord y
     * @param levelToBuild level to build
     */
    public BuildBlockViewEvent(int blockX, int blockY, int levelToBuild) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.levelToBuild = levelToBuild;
    }

    /**
     * it used for drawing the build block
     */
    public void viewEventMethod() {
        proxyModel.setBuild(new Coords(blockX,blockY),levelToBuild);
        proxyModel.getDrawerStrategy().drawMap();
        proxyModel.getDrawerStrategy().promptSelectionText();
    }
}
