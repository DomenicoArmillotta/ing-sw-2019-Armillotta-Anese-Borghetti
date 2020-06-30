package it.polimi.ingsw.networktests.communication;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeServer {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createActionExecutor();
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        player1.setPlayerGod(godCardsDeck.createGodCard(God.APOLLO.toString()));
        player2.setPlayerGod(godCardsDeck.createGodCard(God.DEMETER.toString()));
        player3.setPlayerGod(godCardsDeck.createGodCard(God.PAN.toString()));
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(0, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);
        actionExecutor.getNextPower().doAction(null);
        FakeNetworkHandler fakeNetworkHandler = new FakeNetworkHandler(1234);
        fakeNetworkHandler.startServer();
    }
}
