package it.polimi.ingsw.servertests.modeltests.powertreetests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//true
public class FindAvailableCellsMoveTest {
    @Test
    public void ReturnTestAll() throws ParserConfigurationException, SAXException, IOException {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GodCard godCard1 = godCardsDeck.createGodCard("Pan");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo");
        GodCard godCard3 = godCardsDeck.createGodCard("Athena");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);


        Cell[][] map=gameMaster.getActionExecutor().getMap();
        Cell cella11 = map[2][2];
        player1.workersSetup(2, 2, 4, 4);
        player2.workersSetup(4, 2, 4, 1);
        player3.workersSetup(4, 3, 0, 0);
        ActionExecutor actionExecutor=gameMaster.getActionExecutor();
        int[] a=new int[5];
        a[0]=2;
        a[1]=2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);


        List<Cell> MoveCelleCalcolate = actionExecutor.getNextMove().getAvailableCells(0);


        //creo lista con celle giuste per la assert
        int i, j, x, y;
        List<Cell> MoveCellsGiuste = new ArrayList();
        x = player1.getFirstWorker().getCurrentPosition().getX();
        y = player1.getFirstWorker().getCurrentPosition().getY();
        //assertEquals(x,2);
        //assertEquals(y,2);
        System.out.print("Celle giuste == ");
        for (i = x - 1; i < x + 2 && i < 5 && i >= 0; i++) {
            for (j = y - 1; j < y + 2 && j < 5 && j >= 0; j++) {
                if (!map[i][j].equals(cella11)){
                    MoveCellsGiuste.add(map[i][j]);
                    System.out.print(map[i][j].getX());
                    System.out.print(map[i][j].getY());

                }
            }
        }


        assertEquals(MoveCellsGiuste,MoveCelleCalcolate);

    }

}