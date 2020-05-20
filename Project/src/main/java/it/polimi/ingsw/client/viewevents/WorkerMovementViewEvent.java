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
        WorkerClient worker11=new WorkerClient();
        WorkerClient worker12=new WorkerClient();
        WorkerClient worker21=new WorkerClient();
        WorkerClient worker22=new WorkerClient();
        worker11.setOwner("marco");
        worker12.setOwner("marco");
        worker21.setOwner("davide");
        worker22.setOwner("davide");

        ProxyModel proxyModel = new ProxyModel();
        proxyModel.createMap();
        WorkerClient worker=new WorkerClient();
        worker.setPosition(new Coords(currX,currY));
        worker.setOwner("marco");
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getMap(),worker,new Coords(currX,currY));
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"marco","davide","0");
    }
}
