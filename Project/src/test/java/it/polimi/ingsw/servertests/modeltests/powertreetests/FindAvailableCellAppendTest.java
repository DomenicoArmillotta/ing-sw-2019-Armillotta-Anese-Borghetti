package it.polimi.ingsw.servertests.modeltests.powertreetests;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindAvailableCellAppendTest {
    @Test
    public void correctlyAppendFindAvailableCellsDontMoveUp() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Athena");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.getMap()[1][0].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;


        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);//find cell move

    }
    @Test
    public void dontActivateDontMoveUp() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Athena");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.GROUND);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;


        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        //assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 6);
        assertEquals(true, true);
    }
    @Test
    public void testIfremoveMalusEffect() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Athena");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 4, 4, 4); /* modificata posizione firstWorker (Marco) */

        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        //assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell move
        //assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 7);

        actionExecutor.nextTurn();
        actionExecutor.nextTurn();
        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer().getName(), player1.getName());
        userInput[0] = 1; /* modificato input (Marco) */
        userInput[1] = 1; /* modificato input (Marco) */
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0); /* aggiunto assert (Marco) */
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);  /* aggiunto assert (Marco) */
        userInput[0] = 1; /* modificato input (Marco) */
        userInput[1] = 2; /* modificato input (Marco) */
        //assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);  /* aggiunto assert (Marco) */
        assertEquals(player3.getPlayerGod().getPowerList().size(), 6);
        //assertEquals(player2.getPlayerGod().getPowerList().size(), 6);
    }
    @Test
    public void otherPlayersCantMoveUpDuringTurnAthena() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Athena");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        map[2][2].setBuildingLevel(Level.BASE);
        map[3][4].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);
        //muovo 00 in 10 e attivo athena
        int[] userInput = new int[2];

        userInput[0] = 0;
        userInput[1] = 0;

        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPlayer().getPlayerGod().getPowerList().size(), 7);

        actionExecutor.nextTurn();
        //muovo player 2 da 21 in 22 ma non devo poter fare la mossa
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=1;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=2;
        userInput[1]=2;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);
        userInput[0]=1;
        userInput[1]=2;
        actionExecutor.getNextPower().doAction(userInput);

        actionExecutor.nextTurn();
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=4;
        userInput[1]=4;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=3;
        userInput[1]=3;
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        actionExecutor.nextTurn();

        assertEquals(actionExecutor.getCurrentPlayer().getName(),player1.getName());
        userInput[0]=1;
        userInput[1]=0;
        actionExecutor.getNextPower().doAction(userInput);
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=0;
        userInput[1]=0;
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(player3.getPlayerGod().getPowerList().size(),6);
        assertEquals(player2.getPlayerGod().getPowerList().size(),6);
    }
    @Test
    public void playersCantMoveUpDuringMalusAthenaButCanWhenAthenaIsntActive() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        List<Player> playerQueue = new ArrayList<>();
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        GodCard godCard1 = godCardsDeck.createGodCard("Athena");
        GodCard godCard2 = godCardsDeck.createGodCard("Pan ");
        GodCard godCard3 = godCardsDeck.createGodCard("Apollo");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        Cell[][] map = actionExecutor.getMap();
        map[1][0].setBuildingLevel(Level.BASE);
        map[2][2].setBuildingLevel(Level.BASE);
        map[3][4].setBuildingLevel(Level.BASE);
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 4, 2, 1);
        player3.workersSetup(1, 2, 4, 4);
        //muovo 00 in 10 e attivo athena
        int[] userInput = new int[2];
        userInput[0] = 0;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//find cell select
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//select
        userInput[0] = 1;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);//move
        assertEquals(actionExecutor.getPrevPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);//wincheck
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);//findAvailabeCellsBuild
        userInput[0] = 0;
        userInput[1] = 0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);//build

        //muovo player 2 da 21 in 22 ma non devo poter fare la mossa

        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=2;
        userInput[1]=1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=2;
        userInput[1]=2;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);
        userInput[0]=2;
        userInput[1]=0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=2;
        userInput[1]=1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);


        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getCurrentPlayer(),player3);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=4;
        userInput[1]=4;
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=3;
        userInput[1]=4;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(), 7);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),-1);
        userInput[0]=4;
        userInput[1]=3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=3;
        userInput[1]=4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);


        userInput[0]=1;
        userInput[1]=1;
        actionExecutor.getNextPower().doAction(userInput);
        assertEquals(actionExecutor.getCurrentPlayer().getName(),player1.getName());
        actionExecutor.getNextPower().doAction(userInput);
        userInput[0]=0;
        userInput[1]=1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        assertEquals(player3.getPlayerGod().getPowerList().size(),6);
        assertEquals(player2.getPlayerGod().getPowerList().size(),6);

        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=1;
        userInput[1]=1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);



        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        assertEquals(actionExecutor.getCurrentPlayer(),player2);
        userInput[0]=2;
        userInput[1]=0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);
        userInput[0]=2;
        userInput[1]=1;
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(),6);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        assertEquals(actionExecutor.getCurrentPlayer().getPlayerGod().getPowerList().size(),6);
        assertEquals(actionExecutor.getNextPower().doAction(userInput),1);
        userInput[0]=2;
        userInput[1]=0;
        assertEquals(actionExecutor.getNextPower().doAction(userInput),0);

    }
}