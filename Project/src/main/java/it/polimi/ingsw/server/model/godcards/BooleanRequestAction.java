package it.polimi.ingsw.server.model.godcards;

import it.polimi.ingsw.server.controller.Controller;

/**
 * manage boolean requests for particular gods with BooleanRequestActionStrategy
 */

public interface BooleanRequestAction {
    /**
     *
     * @param controller use controller to execute a particular power
     *  @param booleanChoice contains the reply in Boolean
     */
    void BooleanRequestStrategy(Controller controller,Boolean booleanChoice);
}
