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
        proxyModel.getDrawerStrategy().createPlayer("a");
        proxyModel.getDrawerStrategy().createPlayer("b");
        proxyModel.getDrawerStrategy().createPlayer("c");
        //nella creazione dei worker vengono anche posizionati sulla mappa
        System.out.println("nome = "+proxyModel.getPlayers().isEmpty());
        proxyModel.getDrawerStrategy().createWorker1(proxyModel.getPlayers().get(0),new Coords(1,1),0);
        proxyModel.getDrawerStrategy().createWorker2(proxyModel.getPlayers().get(0),new Coords(2,1),0);
        proxyModel.getDrawerStrategy().createWorker1(proxyModel.getPlayers().get(1),new Coords(1,2),1);
        proxyModel.getDrawerStrategy().createWorker2(proxyModel.getPlayers().get(1),new Coords(2,2),1);
        proxyModel.getDrawerStrategy().createWorker1(proxyModel.getPlayers().get(2),new Coords(1,3),2);
        proxyModel.getDrawerStrategy().createWorker2(proxyModel.getPlayers().get(2),new Coords(2,3),2);
        //faccio setup  imposto ground su mappa
        proxyModel.getDrawerStrategy().setup();
        //seleziono due worer DISEGNO 1
        proxyModel.getPlayers().get(0).getWorker1().setIsSelected(1);
        proxyModel.getPlayers().get(2).getWorker1().setIsSelected(1);
        //disegno
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        //seleziono DISEGNO 2
        proxyModel.getDrawerStrategy().setSelectableCell(coordsArray,1);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        //moviamo un worker
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getPlayers().get(0).getWorker1(),new Coords(4,4));
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        //build
        proxyModel.getDrawerStrategy().setBuild(new Coords(4,4),4);
        proxyModel.getDrawerStrategy().setBuild(new Coords(2,3),4);
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        //muovo giocatore dove ho costruito
        proxyModel.getDrawerStrategy().setBuild(new Coords(2,4),1);
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getPlayers().get(2).getWorker2(), new Coords(2,4));
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));
        proxyModel.getDrawerStrategy().setMoveWorker(proxyModel.getPlayers().get(2).getWorker2(), new Coords(2,3));
        proxyModel.getPlayers().get(2).getWorker2().getPosition();
        proxyModel.getDrawerStrategy().drawMap(proxyModel.getPlayers().get(0),proxyModel.getPlayers().get(1),proxyModel.getPlayers().get(2));

        //win and loose
        proxyModel.getDrawerStrategy().drawLooseGame();
        proxyModel.getDrawerStrategy().drawWinGame();
    }


}