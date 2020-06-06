package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkerSelectionViewEvent extends ViewEvent {
    int workerX;
    int workerY;
    ProxyModel proxyModel = ProxyModel.instance();

    public WorkerSelectionViewEvent(int workerX, int workerY) {
        this.workerX = workerX;
        this.workerY = workerY;
    }

    public void viewEventMethod() {
        List<Coords> coordsList = new ArrayList<>();
        coordsList.add(new Coords(workerX, workerY));
        proxyModel.getMap()[workerX][workerY].getWorker().select();
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should move the selected worker typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired  "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    }
}
