package it.polimi.ingsw.servertests.virtualviewtests.clienttoeventtest;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.model.godcards.GodCard;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.virtualview.serverevents.BooleanEvent;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BooleanEventTest {
    @Test
    public void booleanRequestSimpleTestWithArtemis() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        GodCard godCard = godCardsDeck.createGodCard("artemis");
        ActionExecutor.instance().createMap();
        int[] userInput = new int[2];

        Player player = new Player("matteo");
        player.setPlayerGod(godCard);
        player.workersSetup(0,0,0,1);
        ActionExecutor.instance().setCurrentPlayer(player);

        Controller controller = new Controller();
        ActionExecutor actionExecutor = ActionExecutor.instance();


        ActionExecutor.instance().getNextPower().doAction(null);
        ActionExecutor.instance().getNextPower().doAction(userInput);
        userInput[0] = 1;
        userInput[1] = 1;
        ActionExecutor.instance().getNextPower().doAction(userInput);
        ActionExecutor.instance().getNextPower().doAction(userInput);
        ActionExecutor.instance().getNextPower().doAction(userInput);
        BooleanEvent booleanEvent = new BooleanEvent(false);
        booleanEvent.serverEventMethod(controller);
        System.out.println("ciao");
    }
}