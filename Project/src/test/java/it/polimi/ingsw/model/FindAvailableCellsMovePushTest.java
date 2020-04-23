package it.polimi.ingsw.model;
import it.polimi.ingsw.model.*;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAvailableCellsMovePushTest {
    @Test
    public void TestWorkerNonMio() {

        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.MINOTAUR.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        //actionExecutor.cleanActionExecutor();
        Cell[][] map = gameMaster.getActionExecutor().getMap();
        Cell cella11 = map[2][2];
        Cell cella21 = map[2][3];
        Cell cellaPush = map[2][4];

        player1.workersSetup(2, 2, 4, 4);
        player2.workersSetup(2, 3, 4, 1);
        player3.workersSetup(4, 3, 0, 0);


        int[] a = new int[5];
        a[0] = 2;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);
        actionExecutor.getNextPower().doAction(null);
        List<Cell> MoveCelleCalcolate = actionExecutor.getNextMove().getAvailableCells();


        //creo lista con celle giuste per la assert cioe con anche il worker21
        int i, j, x, y;
        List<Cell> MoveCellsGiuste = new ArrayList();
        x = player1.getFirstWorker().getCurrentPosition().getX();
        y = player1.getFirstWorker().getCurrentPosition().getY();
        //assertEquals(x,2);
        //assertEquals(y,2);
        System.out.print("Celle giuste == ");
        for (i = x - 1; i < x + 2 && i < 5 && i >= 0; i++) {
            for (j = y - 1; j < y + 2 && j < 5 && j >= 0; j++) {
                if (!map[i][j].equals(cella11) && !map[i][j].equals(cella21)) {
                    MoveCellsGiuste.add(map[i][j]);
                    System.out.print(map[i][j].getX());
                    System.out.println(map[i][j].getY());

                }
            }
        }
        MoveCellsGiuste.add(cella21);
        assertEquals(MoveCellsGiuste, MoveCelleCalcolate);


    }
    @Test
    public void TestWorkerMio() {
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playersQueue, 3);
        player1.setPlayerGod(gameMaster.getGodList().get(God.MINOTAUR.ordinal()));
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        //actionExecutor.cleanActionExecutor();
        Cell[][] map = gameMaster.getActionExecutor().getMap();
        Cell cella11 = map[2][2];
        Cell cella21 = map[2][3];
        Cell cellaPush = map[2][4];

        player1.workersSetup(2, 2, 2, 3);
        player2.workersSetup(4, 2, 4, 1);
        player3.workersSetup(4, 3, 0, 0);


        int[] a = new int[5];
        a[0] = 2;
        a[1] = 2;
        actionExecutor.getNextPower().doAction(null);
        actionExecutor.getNextPower().doAction(a);
        actionExecutor.getNextPower().doAction(null);
        List<Cell> MoveCelleCalcolate = actionExecutor.getNextMove().getAvailableCells();


        //creo lista con celle giuste per la assert cioe con anche il worker21
        int i, j, x, y;
        List<Cell> MoveCellsGiuste = new ArrayList();
        x = player1.getFirstWorker().getCurrentPosition().getX();
        y = player1.getFirstWorker().getCurrentPosition().getY();
        //assertEquals(x,2);
        //assertEquals(y,2);
        System.out.print("Celle giuste == ");
        for (i = x - 1; i < x + 2 && i < 5 && i >= 0; i++) {
            for (j = y - 1; j < y + 2 && j < 5 && j >= 0; j++) {
                if (!map[i][j].equals(cella11) && !map[i][j].equals(cella21)) {
                    MoveCellsGiuste.add(map[i][j]);
                    System.out.print(map[i][j].getX());
                    System.out.println(map[i][j].getY());

                }
            }
        }
        assertEquals(MoveCellsGiuste, MoveCelleCalcolate);
     /*
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(3, playerQueue);
        gameMaster.createGodList();
        player1.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player2.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        player3.setPlayerGod(gameMaster.getGodList().get(God.APOLLO.ordinal()));
        gameMaster.createActionExecutor();
        GodCard godCard1 = player1.getPlayerGod();
        GodCard godCard2 = player2.getPlayerGod();
        GodCard godCard3 = player3.getPlayerGod();
        gameMaster.getActionExecutor().createMap();
        Cell[][] map=gameMaster.getActionExecutor().getMap();
        Cell cella11 = map[2][2];
        Cell cella21 = map[2][3];
        Cell cellaPush = map[2][4];
        cellaPush.setWorkerOnCell(null);
        player1.workersSetup(2, 2, 2, 3);
        player2.workersSetup(4, 2, 4, 1);
        player3.workersSetup(4, 3, 0, 0);
        Worker worker11=new Worker(cella11);
        Worker worker21=new Worker(cella21);
        worker11=player1.getFirstWorker();
        worker21=player2.getFirstWorker();

        int[] a=new int[5];
        a[0]=2;
        a[1]=2;
        player1.getPlayerGod().getFindAvailableCellsList().get(0).doAction(null);
        player1.getPlayerGod().getSelectMoveList().get(0).doAction(a);
        player1.getPlayerGod().getFindAvailableCellsList().get(1).doAction(null);


        //creo lista con celle giuste per la assert cioe senza la cella dove si trova il mio worker
        int i, j, x, y;
        List<Cell> MoveCellsGiuste = new ArrayList();
        x = worker11.getCurrentPosition().getX();
        y = worker11.getCurrentPosition().getY();
        //assertEquals(x,2);
        //assertEquals(y,2);
        System.out.print("Celle giuste == ");
        for (i = x - 1; i < x + 2 && i < 5 && i >= 0; i++) {
            for (j = y - 1; j < y + 2 && j < 5 && j >= 0; j++) {
                if (!map[i][j].equals(cella11) && !map[i][j].equals(cella21) ){
                    MoveCellsGiuste.add(map[i][j]);
                    System.out.print(map[i][j].getX());
                    System.out.print(map[i][j].getY());

                }
            }
        }
*/
    }

}