package it.polimi.ingsw.model.powertree;

import it.polimi.ingsw.model.*;

public abstract class Power {

    /* Every Power can reach Map, Players, GodCards and other Powers through executorPointer */
    protected ActionExecutor executorPointer = ActionExecutor.instance(); /* Singleton ActionExecutor */

    public ActionExecutor getExecutorPointer() {
        return executorPointer; /* Singleton ActionExecutor */
    }

    public int PointerBack() {

        Power powerPtr = executorPointer.getPowerPtr();
        if (powerPtr != null) {
            Power indexPtr = executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 0; indexPtr != powerPtr; index++) {
                indexPtr = executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(index);
            }
            executorPointer.setPowerPtr(executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(index - 2));
            return 0;
        } else {
            return -1;
        }
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
