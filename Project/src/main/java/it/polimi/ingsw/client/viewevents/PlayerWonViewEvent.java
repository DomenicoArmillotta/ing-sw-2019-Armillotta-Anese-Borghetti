package it.polimi.ingsw.client.viewevents;
import it.polimi.ingsw.client.proxymodel.*;

import java.net.Socket;

/**
 * shows the player who loses the game on the screen
 */
public class PlayerWonViewEvent extends ViewEvent {
    String winnerName;
    ProxyModel proxyModel = ProxyModel.instance();
    Socket socket = proxyModel.thisScoket;

    public PlayerWonViewEvent(String winnerName) {
        this.winnerName = winnerName;
    }

    /**
     * shows the text of the player who loses the game on the screen
     */
    public void viewEventMethod(){
        //System.out.println("hai vinto");
        proxyModel.getDrawerStrategy().drawWinGame();
        proxyModel.setPhase(Phase.DISCONNECTED);
    }
}
