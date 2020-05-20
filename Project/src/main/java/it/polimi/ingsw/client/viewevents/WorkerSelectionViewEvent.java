package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkerSelectionViewEvent extends ViewEvent {
    int workerX;
    int workerY;

    public WorkerSelectionViewEvent(int workerX, int workerY) {
        this.workerX = workerX;
        this.workerY = workerY;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        List<Coords> coords=new ArrayList<>();
        coords.add(new Coords(this.workerX,this.workerY));
        ProxyModel.instance().getDrawerStrategy().setSelectableCell(coords);
        ProxyModel.instance().getDrawerStrategy().drawMap();
    }
}
