package it.polimi.ingsw.server.virtualview.listeners;
import it.polimi.ingsw.server.model.mvevents.actionevents.BooleanRequestEvent;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
/**
 * when in the server BooleanActionEvent is triggered,
 * the corresponding eventBean is created, it is inserted in the buffer which will subsequently be sent
 */
public class BooleanActionListener extends Listener {

    private static BooleanActionListener instance;

    public static BooleanActionListener instance() {
        if (instance == null) {
            instance = new BooleanActionListener();
        }
        return instance;
    }

    public void createPromptBean(BooleanRequestEvent doubleBooleanRequest) {
        EventBean eventBean =  doubleBooleanRequest.eventMethod();
        eventsBuffer.setLastEventBean(eventBean);
        /* send event to clients */
    }
}
