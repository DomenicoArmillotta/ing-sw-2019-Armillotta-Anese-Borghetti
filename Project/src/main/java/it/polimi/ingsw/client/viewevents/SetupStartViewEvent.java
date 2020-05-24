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
        proxyModel.getTurn().setCurrentPlayer(new Player(firstPlayer));
        proxyModel.getTurn().setNextPlayer(new Player(secondPlayer));
        proxyModel.getTurn().setPreviousPlayer(new Player(thirdPlayer));

        System.out.println("Game STARTED");
    }
}
