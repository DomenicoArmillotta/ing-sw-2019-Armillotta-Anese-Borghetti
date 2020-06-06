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
        //System.out.println("è il tuo turno "+ProxyModel.instance().getTurn().getCurrentPlayer().getName());
        //System.out.println("il prossimo turno è di "+ProxyModel.instance().getTurn().getNextPlayer().getName());
        List<Coords> coordsArray = new ArrayList();
        coordsArray.add(new Coords(1,1));
        coordsArray.add(new Coords(1,2));
        coordsArray.add(new Coords(1,4));
        coordsArray.add(new Coords(1,3));
        ProxyModel proxyModel = ProxyModel.instance();
        proxyModel.createMap();
        CliDrawer CliDrawer=new CliDrawer();
        proxyModel.setDrawerStrategy(CliDrawer);
        //creo tutti i player e worker
        proxyModel.addPlayer("a");
        proxyModel.addPlayer("b");
        proxyModel.addPlayer("c");
        proxyModel.createTurn();
        proxyModel.getTurn().setCurrentPlayer(proxyModel.getPlayers().get(1));
        System.out.println("nome = "+proxyModel.getPlayers().isEmpty());
        //nella creazione dei worker vengono anche posizionati sulla mappa
        proxyModel.createWorker1(proxyModel.getPlayers().get(0),new Coords(1,1),0);
        proxyModel.createWorker2(proxyModel.getPlayers().get(0),new Coords(2,1),0);
        proxyModel.createWorker1(proxyModel.getPlayers().get(1),new Coords(1,2),1);
        proxyModel.createWorker2(proxyModel.getPlayers().get(1),new Coords(2,2),1);
        proxyModel.createWorker1(proxyModel.getPlayers().get(2),new Coords(1,3),2);
        proxyModel.createWorker2(proxyModel.getPlayers().get(2),new Coords(2,3),2);
        //faccio setup  imposto ground su mappa
        //proxyModel.getDrawerStrategy().setup();
        //seleziono due worer DISEGNO 1
        proxyModel.getPlayers().get(0).getWorker1().select();
        proxyModel.getPlayers().get(2).getWorker1().select();
        //disegno
        proxyModel.getDrawerStrategy().drawMap();
        //seleziono DISEGNO 2
        proxyModel.addSelectableCells(coordsArray);
        proxyModel.getDrawerStrategy().drawMap();
        //moviamo un worker
        proxyModel.setMoveWorker(proxyModel.getPlayers().get(0).getWorker1(),new Coords(4,4));
        proxyModel.getDrawerStrategy().drawMap();
        //build

        proxyModel.setBuild(new Coords(4,4),4);
        proxyModel.setBuild(new Coords(2,3),4);
        proxyModel.getDrawerStrategy().drawMap();
        //muovo giocatore dove ho costruito e DESELEZIONO
        proxyModel.setBuild(new Coords(2,4),1);
        proxyModel.setMoveWorker(proxyModel.getPlayers().get(2).getWorker2(), new Coords(2,4));
        System.out.print("PROVAAAAAAAAAAAA");
        proxyModel.removeSelectableCells(coordsArray);
        proxyModel.getDrawerStrategy().drawMap();
        proxyModel.setMoveWorker(proxyModel.getPlayers().get(2).getWorker2(), new Coords(2,3));
        proxyModel.getPlayers().get(2).getWorker2().getPosition();
        proxyModel.getDrawerStrategy().drawMap();
        List<Coords> coordsArray2 = new ArrayList();
        coordsArray2.add(new Coords(4,4));
        //proxyModel.setSelectableCell(coordsArray2,2);
        proxyModel.getDrawerStrategy().drawMap();

        //win and loose
        proxyModel.getDrawerStrategy().drawLooseGame();
        proxyModel.getDrawerStrategy().drawWinGame();
    }


}