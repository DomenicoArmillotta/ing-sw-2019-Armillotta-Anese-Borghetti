package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

/**
 * to show the prompt to make the choice
 */
public class DoubleMoveViewEvent extends ViewEvent {
    String promptText;
    ProxyModel proxyModel = ProxyModel.instance();
    /* aggiungere livello */

    public DoubleMoveViewEvent(String promptText) {
        this.promptText = promptText;
    }
    /**
     * used for show the prompt to choose if move twice
     */
    public void viewEventMethod() {
        proxyModel.getDrawerStrategy().promptChoice(promptText);
        //System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m"+", "+promptText);
        //System.out.println("Answer by typing "+"\u001B[33m"+"bool"+"\u001B[0m"+" followed by "+"\u001B[33m"+"true"+"\u001B[0m"+" or "+"\u001B[33m"+"false"+"\u001B[0m"+".");
        //System.out.println("If "+"\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m"+" answers"+"\u001B[33m"+" false"+"\u001B[0m"+", he/she should then build a block typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");

    }
}