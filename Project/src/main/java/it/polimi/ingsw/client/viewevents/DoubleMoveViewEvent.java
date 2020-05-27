package it.polimi.ingsw.client.viewevents;

import it.polimi.ingsw.client.proxymodel.Coords;
import it.polimi.ingsw.client.proxymodel.ProxyModel;

public class DoubleMoveViewEvent extends ViewEvent {
    String promptText;
    ProxyModel proxyModel = ProxyModel.instance();
    /* aggiungere livello */

    public DoubleMoveViewEvent(String promptText) {
        this.promptText = promptText;
    }

    public void viewEventMethod() {
        System.out.println("CLI_PROMPT: "+promptText);
    }
}