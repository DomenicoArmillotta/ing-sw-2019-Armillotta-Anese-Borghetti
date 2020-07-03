package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;
/**
 * to show the prompt to make the choice
 */
public class DoubleBuildViewEvent extends ViewEvent {
    String promptText;
    /* aggiungere livello */

    public DoubleBuildViewEvent(String promptText) {
        this.promptText = promptText;
    }
    /**
     * used for show the prompt to choose if build twice
     */
    public void viewEventMethod() {
        ProxyModel.instance().getDrawerStrategy().promptChoice(promptText);
        //System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m"+", "+promptText);
        //System.out.println("Answer by typing "+"\u001B[33m"+"bool"+"\u001B[0m"+" followed by "+"\u001B[33m"+"true"+"\u001B[0m"+" or "+"\u001B[33m"+"false"+"\u001B[0m"+".");
    }
}
