package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;

public abstract class Power {

    /* Every Power can reach Map, Players, GodCards and other Powers through executorPointer */
    protected ActionExecutor executorPointer = ActionExecutor.instance(); /* Singleton ActionExecutor */

    public ActionExecutor getExecutorPointer() {
        return executorPointer;
    }

    public int doAction(int[] userInput) { /* Overridden in subclasses */
        /* No action */
        return -1; /* Action failed: this method should be called from Power subclasses */
    }

    public int pointerBack() {
        int index;
        Power powerPtr = executorPointer.getPowerPtr();
        if (powerPtr != null) {
            Power indextPtr = executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(0);
            for (index = 0; indextPtr != powerPtr; index++) {
                indextPtr = executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(index);
            }
            executorPointer.setPowerPtr(executorPointer.getCurrentPlayer().getPlayerGod().getPowerList().get(index - 2));
            return 0;
        } else {
            return -1;
        }
    }

    public void clearPower() {
        /* Nothing to clean */
    }

}
