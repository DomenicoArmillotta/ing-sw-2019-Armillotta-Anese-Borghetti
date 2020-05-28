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
        proxyModel.getDrawerStrategy().setSelectableCell(coordsList,1);
        //proxyModel.getMap()[workerX][workerY].getWorker().setIsSelected(2);
        /* if(proxyModel.getPlayers().size() == 2) proxyModel.getDrawerStrategy().drawMap();
        else proxyModel.getDrawerStrategy().drawMap(); */
        proxyModel.getDrawerStrategy().setSelectableCell(coordsList,0);
        //proxyModel.getMap()[workerX][workerY].getWorker().setIsSelected(0);
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should move the selected worker typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired  "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    }
}
