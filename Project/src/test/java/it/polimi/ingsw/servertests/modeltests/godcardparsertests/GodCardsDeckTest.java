package it.polimi.ingsw.servertests.modeltests.godcardparsertests;

import it.polimi.ingsw.server.model.godcardparser.God;
import it.polimi.ingsw.server.model.godcardparser.GodCard;
import it.polimi.ingsw.server.model.godcardparser.GodCardsDeck;
import it.polimi.ingsw.server.model.Player;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GodCardsDeckTest {
    @Test
    public void checkIfGodCardDeckWork() throws ParserConfigurationException, SAXException, IOException {
        GodCardsDeck newDeck = new GodCardsDeck();
        List<Player> playersQueue = new ArrayList<>();
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        player1.setPlayerGod(newDeck.createGodCard(God.APOLLO.toString()));
        player2.setPlayerGod(newDeck.createGodCard(God.MORTAL.toString()));
        assertEquals(player1.getName(),"Matteo");
        assertEquals(player2.getName(),"Domenico");
        assertEquals(player1.getPlayerGod().getGodName(),"Apollo");
        assertEquals(player2.getPlayerGod().getGodName(),"Mortal");
        assertEquals(player1.getPlayerGod().getPowerList().size(),6);
        assertEquals(player2.getPlayerGod().getPowerList().size(),6);
    }
    @Test
    public void loadAllCardsTest() throws ParserConfigurationException, SAXException, IOException {
        List<Player> playersQueue = new ArrayList<>();
        GodCardsDeck newDeck = new GodCardsDeck();
        GodCard tempGodCard;
        Player player1 = new Player("Matteo");
        Player player2 = new Player("Domenico");
        Player player3 = new Player("Marco");
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        for (God god : God.values()) {
            tempGodCard=null;
            tempGodCard = newDeck.createGodCard(god.toString());
            System.out.println(tempGodCard.getGodName());
        }
    }
}