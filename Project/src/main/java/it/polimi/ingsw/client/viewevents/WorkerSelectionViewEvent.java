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
        worker.setPosition(new Coords(workerX,workerY));
        worker.setOwner("marco");
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getMap(),worker,new Coords(workerX,workerY));
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"marco","davide","0");
    }
}
