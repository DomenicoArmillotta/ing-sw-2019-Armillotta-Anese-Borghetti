package it.polimi.ingsw.server.model.powertree;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class killServerWhenWin {

    @Test
    public void killGameWhenWinIsTriggered() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck= new GodCardsDeck();
        Controller controller = new Controller();

        final Player player1 = new Player("matteo");
        final Player player2 = new Player("pietro");
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        GameMaster gameMaster = new GameMaster(playerList,2);

        gameMaster.createActionExecutor();
        player1.setPlayerGod(godCardsDeck.createGodCard("pan"));
        player2.setPlayerGod(godCardsDeck.createGodCard("atlas"));


        Cell cell = gameMaster.getActionExecutor().getMap()[1][1];
        player1.setFirstWorker(new Worker(gameMaster.getActionExecutor().getMap()[1][1]));
        player1.setSecondWorker(new Worker(gameMaster.getActionExecutor().getMap()[1][2]));
        player2.setFirstWorker(new Worker(gameMaster.getActionExecutor().getMap()[1][3]));
        player2.setSecondWorker(new Worker(gameMaster.getActionExecutor().getMap()[1][4]));
        gameMaster.getActionExecutor().getMap()[2][2].setBuildingLevel(Level.TOP);
        gameMaster.getActionExecutor().getMap()[1][2].setBuildingLevel(Level.MID);
        ActionExecutor.instance().setCurrentPlayer(player1);
        ActionExecutor.instance().setNextPlayer(player2);
        ActionExecutor.instance().setPrevPlayer(player2);
        int[] userInput = new int[2];
        userInput[0] = 1;
        userInput[1] = 2;
        ActionExecutor.instance().getNextPower().doAction(userInput);
        ActionExecutor.instance().getNextPower().doAction(userInput);
        userInput[0] = 2;
        userInput[1] = 2;
        ActionExecutor.instance().getNextPower().doAction(userInput);
        ActionExecutor.instance().getNextPower().doAction(userInput);
        assertEquals(EventsBuffer.instance().getEndGame(),true);



    }

}