package it.polimi.ingsw.client.proxymodel;

import it.polimi.ingsw.server.model.Worker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyModelTest {
    @Test
    public void BuildTest() {
        Map map;
        Worker worker11;
        Worker worker12;
        Worker worker21;
        Worker worker22;
        Drawer drawer;

        ProxyModel proxyModel = new ProxyModel();
        proxyModel.createMap();
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setBuild(proxyModel.getMap(),new Coords(2,3),3);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"0","0","0");
    }
    @Test
    public void MoveTest() {

        Map map;
        WorkerClient worker11=new WorkerClient();
        WorkerClient worker12=new WorkerClient();
        WorkerClient worker21=new WorkerClient();
        WorkerClient worker22=new WorkerClient();
        Drawer drawer;
        worker11.setOwner("marco");
        worker12.setOwner("marco");
        worker21.setOwner("davide");
        worker22.setOwner("davide");

        ProxyModel proxyModel = new ProxyModel();
        proxyModel.createMap();
        WorkerClient worker=new WorkerClient();
        worker.setPosition(new Coords(1,1));
        worker.setOwner("marco");
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getMap(),worker,new Coords(1,2));
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"marco","davide","0");
    }
    @Test
    public void BuildTest2() {
        Map map;
        WorkerClient worker11;
        WorkerClient worker12;
        WorkerClient worker21;
        WorkerClient worker22;
        Drawer drawer;

        ProxyModel proxyModel = new ProxyModel();
        proxyModel.createMap();
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setBuild(proxyModel.getMap(),new Coords(2,3),2);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"0","0","0");
        proxyModel.getDrawerStrategy().drawLooseGame();
    }
    @Test
    public void SelectTest() {
        Map map;
        WorkerClient worker11;
        WorkerClient worker12;
        WorkerClient worker21;
        WorkerClient worker22;
        Drawer drawer;
        List<Coords> coordsArray = new ArrayList();
        coordsArray.add(new Coords(1,1));
        coordsArray.add(new Coords(1,2));
        coordsArray.add(new Coords(1,4));
        coordsArray.add(new Coords(1,3));
        ProxyModel proxyModel = new ProxyModel();
        proxyModel.createMap();
        CliDrawer CliDrawer=new CliDrawer();
        CliDrawer.setup(proxyModel.getMap());
        proxyModel.setDrawerStrategy(CliDrawer);
        proxyModel.getDrawerStrategy().setSelectableCell(proxyModel.getMap(),coordsArray);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getMap(),"0","0","0");
    }


}