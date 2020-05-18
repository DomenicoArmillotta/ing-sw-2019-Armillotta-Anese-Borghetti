package it.polimi.ingsw.server.virtualview.serverevents;

import it.polimi.ingsw.server.controller.Controller;

public class StringEvent extends ServerEvent {
    String userInput;
    public StringEvent(String userInput) {
        this.userInput = userInput;
    }

    public void serverEventMethod(Controller controller) {
        /* int result = controller.playerLogin(userInput); result: 0 se il nickname esiste già,
        1 se il nickname non esiste e il player non è il primo, 2 se il nick non esiste
        e il player è il primo, 3 altrimenti (errore strano) */
        /* if(result == 0)  inserisci nell'eb evento di login fallito */
    }

}
