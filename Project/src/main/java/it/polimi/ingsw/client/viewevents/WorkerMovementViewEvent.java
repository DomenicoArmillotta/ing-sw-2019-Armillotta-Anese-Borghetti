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

    public WorkerMovementViewEvent(int prevX, int prevY, int currX, int currY){
        this.prevX = prevX;
        this.prevY = prevY;
        this.currX = currX;
        this.currY = currY;
    }
    public boolean startWaiting() {
        return false;
    }

    public void viewEventMethod() {
        /* ProxyModel.instance().getDrawerStrategy().setMoveWorker(new Coords(this.prevX,this.prevX),new Coords(this.currX,this.currY));
        ProxyModel.instance().getDrawerStrategy().drawMap(); */
    }
}
