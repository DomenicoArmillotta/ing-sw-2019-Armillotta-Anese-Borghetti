package it.polimi.ingsw.client.viewevents;
import it.polimi.ingsw.client.proxymodel.*;

public class SetupStartViewEvent extends ViewEvent {
    String firstPlayer;
    String secondPlayer;
    String thirdPlayer;
    ProxyModel proxyModel = ProxyModel.instance();

    public SetupStartViewEvent(String firstPlayer, String secondPlayer, String thirdPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
    }

    public void viewEventMethod() {
        proxyModel.createTurn();
        Player player1 = new Player(firstPlayer);
        Player player2 = new Player(secondPlayer);
        if(secondPlayer.equals(thirdPlayer)) {
            proxyModel.getTurn().setCurrentPlayer(player1);
            proxyModel.getTurn().setNextPlayer(player2);
            proxyModel.getTurn().setPreviousPlayer(player2);
        } else {
            Player player3 = new Player(thirdPlayer);
            proxyModel.getTurn().setCurrentPlayer(player1);
            proxyModel.getTurn().setNextPlayer(player2);
            proxyModel.getTurn().setPreviousPlayer(player3);
        }

        System.out.println("Game STARTED");
    }
}
