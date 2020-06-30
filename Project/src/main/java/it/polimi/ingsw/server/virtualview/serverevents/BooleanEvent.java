package it.polimi.ingsw.server.virtualview.serverevents;


import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.godcards.BooleanRequestAction;

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
