package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

/**
 * draw the movement done by the selected worker
 */
public class WorkerMovementViewEvent extends ViewEvent {
    int prevX;
    int prevY;
    int currX;
    int currY;

    ProxyModel proxyModel = ProxyModel.instance();

    public WorkerMovementViewEvent(int prevX, int prevY, int currX, int currY){
        this.prevX = prevX;
        this.prevY = prevY;
        this.currX = currX;
        this.currY = currY;
    }

    /**
     * draw the movement done by the selected worker and the map is updated and draw the build prompt if is necessary
     */
    public void viewEventMethod() {
        proxyModel.setMoveWorker(proxyModel.getMap()[prevX][prevY].getWorker(), new Coords(currX,currY));
        proxyModel.getMap()[currX][currY].getWorker().unselect();
        proxyModel.getDrawerStrategy().drawMap();
        proxyModel.getDrawerStrategy().promptBuildText();
    }
}
