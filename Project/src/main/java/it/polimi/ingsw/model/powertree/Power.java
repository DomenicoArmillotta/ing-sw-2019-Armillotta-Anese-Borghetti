package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

public abstract class Power {

    /* Every Power can reach Map, Players, GodCards and other Powers through executorPointer */
    protected ActionExecutor executorPointer = ActionExecutor.instance(); /* Singleton ActionExecutor */

    public ActionExecutor getExecutorPointer() {
        return executorPointer; /* Singleton ActionExecutor */
    }

    public int doAction(int[] userInput) { /* Overridden in subclasses */
        /* No action */
        return -1; /* Action failed: this method should be called from Power subclasses */
    }

    public int getActionType() {
        return 0;
    }

    public void clearPower() {
        /* Nothing to clean */
    }

}
