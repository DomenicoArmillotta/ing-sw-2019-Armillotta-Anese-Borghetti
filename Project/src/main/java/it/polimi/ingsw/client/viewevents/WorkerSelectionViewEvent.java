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
        if(proxyModel.getPlayers().size() == 2) proxyModel.getDrawerStrategy().drawMap();
        else proxyModel.getDrawerStrategy().drawMap();
        proxyModel.getDrawerStrategy().setSelectableCell(coordsList,0);
        //proxyModel.getMap()[workerX][workerY].getWorker().setIsSelected(0);
    }
}
