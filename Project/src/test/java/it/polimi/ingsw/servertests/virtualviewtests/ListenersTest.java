package it.polimi.ingsw.servertests.virtualviewtests;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import it.polimi.ingsw.server.model.godcards.God;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListenersTest {

    /* public void bindSubjectWithListener(Power subject, Listener listener) {
        subject.initListenerList();
        subject.attachListener(listener);
        listener.setSubject(subject);
    } */

    @Test
    public void listenerTest() throws ParserConfigurationException, SAXException, IOException {
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
        GodCard godCard1 = godCardsDeck.createGodCard("Mortal");
        GodCard godCard2 = godCardsDeck.createGodCard("Apollo ");
        GodCard godCard3 = godCardsDeck.createGodCard("Demeter");
        player1.setPlayerGod(godCard1);
        player2.setPlayerGod(godCard2);
        player3.setPlayerGod(godCard3);
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        player1.workersSetup(1, 1, 4, 2);
        player2.workersSetup(4, 4, 4, 0);
        player3.workersSetup(3, 4, 4, 1);
        int[] userInput = new int[10];

        /* Associo il Listener al Soggetto che ascolta */
       /* player1.getPlayerGod().getFindAvailableCellsList().get(0).initListenerList();
        WaitingForEventListener waitingSelectListener = new WaitingForEventListener();
        player1.getPlayerGod().getFindAvailableCellsList().get(0).attachListener(waitingSelectListener);
        waitingSelectListener.setSubject(player1.getPlayerGod().getFindAvailableCellsList().get(0));
        //bindSubjectWithListener(player1.getPlayerGod().getFindAvailableCellsList().get(0), new WaitingForEventListener());

        player1.getPlayerGod().getFindAvailableCellsList().get(1).initListenerList();
        WaitingForEventListener waitingBuildListener = new WaitingForEventListener();
        player1.getPlayerGod().getFindAvailableCellsList().get(1).attachListener(waitingBuildListener);
        waitingBuildListener.setSubject(player1.getPlayerGod().getFindAvailableCellsList().get(1));

        player1.getPlayerGod().getSelectList().get(0).initListenerList();
        WorkerSelectionListener selectionListener = new WorkerSelectionListener()
        player1.getPlayerGod().getSelectList().get(0).attachListener(selectionListener);
        selectionListener.setSubject(player1.getPlayerGod().getSelectList().get(0));

        player1.getPlayerGod().getMoveList().get(0).initListenerList();
        WorkerMovementListener moveListener = new WorkerMovementListener();
        player1.getPlayerGod().getMoveList().get(0).attachListener(moveListener);
        moveListener.setSubject(player1.getPlayerGod().getMoveList().get(0));

        player1.getPlayerGod().getBuildList().get(0).initListenerList();
        BuildBlockListener buildListener = new BuildBlockListener();
        player1.getPlayerGod().getBuildList().get(0).attachListener(buildListener);
        buildListener.setSubject(player1.getPlayerGod().getBuildList().get(0)); */

        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 1;
        userInput[1] = 1;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 2;
        userInput[1] = 2;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 3;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 1);
/*
        assertEquals(actionExecutor.getNextPower().doAction(null), 0);
        userInput[0] = 4;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 4;
        userInput[1] = 3;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), -1);
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);
        userInput[0] = 4;
        userInput[1] = 4;
        assertEquals(actionExecutor.getNextPower().doAction(userInput), 0);

 */
    }
}
