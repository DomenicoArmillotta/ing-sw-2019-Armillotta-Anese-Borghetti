package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getMap()[prevX][prevY].getWorker(), new Coords(currX,currY));
        //proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        proxyModel.getDrawerStrategy().drawMap();
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should build a block typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired  "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    }
}
