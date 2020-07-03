package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.ProxyModel;
/**
 * draw the prompt for chose to build or move
 */
public class BuildOrMoveViewEvent extends ViewEvent {
    String promptText;
    /* aggiungere livello */

    public BuildOrMoveViewEvent(String promptText) {
        this.promptText = promptText;
    }

    /**
     * draw the prompt for chose to build or move
     */
    public void viewEventMethod() {
        ProxyModel.instance().getDrawerStrategy().promptChoice(promptText);
        //System.out.println("Answer by typing "+"\u001B[33m"+"bool"+"\u001B[0m"+" followed by "+"\u001B[33m"+"true"+"\u001B[0m"+" or "+"\u001B[33m"+"false"+"\u001B[0m"+".");
    }
}
