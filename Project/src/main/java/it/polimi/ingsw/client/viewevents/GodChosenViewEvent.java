package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.GodCards;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class GodChosenViewEvent extends ViewEvent {
    String chosenGod;
    String player;

    public GodChosenViewEvent(String chosenGod, String player) {
        this.chosenGod = chosenGod;
        this.player = player;
    }

    @Override
    public void viewEventMethod() {
        ProxyModel.instance().getTurn().getCurrentPlayer().setGodCard(new GodCards(chosenGod));
        ProxyModel.instance().getTurn().nextTurn();
        /* System.out.println(player+" ha scelto correttamente "+chosenGod.toUpperCase()); */
        System.out.println("\u001B[36m"+player+"\u001B[0m"+" has chosen "+"\u001B[33m"+chosenGod.toLowerCase()+"\u001B[0m"+".");
        if(ProxyModel.instance().getTurn().getCurrentPlayer().getGodCard() == null) {
            System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " may choose a God to play with typing " + "\u001B[33m" + "god" + "\u001B[0m" + " followed by the God's "+ "\u001B[33m" + "name" + "\u001B[0m"+".");
            System.out.println("Choose between the remaining Gods.");
        }
    }

}
