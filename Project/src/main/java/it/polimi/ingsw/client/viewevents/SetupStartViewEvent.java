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

        System.out.println("\u001B[36m"+firstPlayer+"\u001B[0m"+" has started the game.");
        System.out.println("\u001B[36m"+firstPlayer+"\u001B[0m"+" may choose a God to play with typing "+"\u001B[33m"+"god"+"\u001B[0m"+ " followed by the God's "+ "\u001B[33m" + "name" + "\u001B[0m"+".");
        System.out.println("Choose between "+"\u001B[33m"+"apollo"+"\u001B[0m"+", "+"\u001B[33m"+"artemis"+"\u001B[0m"+", "+"\u001B[33m"+"athena"+"\u001B[0m"+", "+"\u001B[33m"+"atlas"+"\u001B[0m"+", "+"\u001B[33m"+"demeter"+"\u001B[0m"+", "+"\u001B[33m"+"hephaestus"+"\u001B[0m"+", "+"\u001B[33m"+"minotaur"+"\u001B[0m"+", "+"\u001B[33m"+"pan"+"\u001B[0m"+", "+"\u001B[33m"+"prometheus"+"\u001B[0m"+".");
        proxyModel.setPhase(1);
    }
}
