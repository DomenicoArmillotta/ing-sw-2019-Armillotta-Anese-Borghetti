package it.polimi.ingsw.server.virtualview.serverevents;
import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
/**
 * this BooleanEvent was generated after the parser decoded the message received from the client and ActionExecutor
 * call the controller.
 * this BooleanEvent is used for the boolean choice
 */
public class BooleanEvent extends ServerEvent {
    private Boolean booleanRequest;

    public BooleanEvent(Boolean booleanRequest){
        this.booleanRequest = booleanRequest;
    }

    @Override
    public void serverEventMethod(Controller controller) {
        ActionExecutor.instance().getCurrentPlayer().getPlayerGod().getBooleanRequestActionStrategy().BooleanRequestStrategy(controller,booleanRequest);
    }
}
