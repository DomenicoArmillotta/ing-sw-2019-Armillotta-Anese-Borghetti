package it.polimi.ingsw.networktests;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.Cell;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.godcardparser.God;
import it.polimi.ingsw.server.model.godcardparser.GodCardsDeck;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InteractionWithControllerTest {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        /* Player player1 = new Player("Marco");
        Player player2 = new Player("Pietro");
        Player player3 = new Player("Domenico");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);
        GameMaster gameMaster = new GameMaster(playerQueue, 3);
        gameMaster.createGodList();
        gameMaster.createActionExecutor();
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        player1.setPlayerGod(godCardsDeck.createGodCard(God.MORTAL));
        player2.setPlayerGod(godCardsDeck.createGodCard(God.DEMETER));
        player3.setPlayerGod(godCardsDeck.createGodCard(God.PAN));
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(4, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);
        actionExecutor.getNextPower().doAction(null); */
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();

    }
}
