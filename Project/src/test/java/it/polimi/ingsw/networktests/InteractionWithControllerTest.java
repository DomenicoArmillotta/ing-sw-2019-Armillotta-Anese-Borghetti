package it.polimi.ingsw.networktests;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class InteractionWithControllerTest {

    public static void main(String[] args) {
        /*
        if(args.length == 0)
            runGui();
        else
            if(args[0].equals("server"))
                runServer();
            else
                if(args[1].equals("client"))
                    cliStart();
                else
                    System.out.println("errore");
        */

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
        player1.setPlayerGod(godCardsDeck.createGodCard(God.MORTAL.toString()));
        player2.setPlayerGod(godCardsDeck.createGodCard(God.DEMETER.toString()));
        player3.setPlayerGod(godCardsDeck.createGodCard(God.PAN.toString()));
        ActionExecutor actionExecutor = gameMaster.getActionExecutor();
        actionExecutor.createMap();
        Cell[][] map = actionExecutor.getMap();
        player1.workersSetup(0, 0, 1, 1);
        player2.workersSetup(4, 1, 2, 1);
        player3.workersSetup(1, 0, 4, 4);
        actionExecutor.getNextPower().doAction(null); */
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
        System.out.println("sono alla fine del test");

    }
}
