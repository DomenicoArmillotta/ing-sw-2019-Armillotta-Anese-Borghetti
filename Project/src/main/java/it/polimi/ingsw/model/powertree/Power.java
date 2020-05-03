package it.polimi.ingsw.model.powertree;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.virtualview.Listener;

import java.util.ArrayList;
import java.util.List;

public abstract class Power {

    /* Every Power can reach Map, Players, GodCards and other Powers through executorPointer */
    protected ActionExecutor executorPointer = ActionExecutor.instance(); /* Singleton ActionExecutor */

    private List<Listener> listenersList;

    /* private Event lastEvent; */

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

    public List<Listener> getListenersList() {
        return listenersList;
    }

    public void notifyListeners() {
        for (int i = 0; i < listenersList.size(); i++) {
            listenersList.get(i).update();
        }
    }

    public void attachListener(Listener listener) {
        listenersList.add(listener);
    }

    public void initListenerList() {
        listenersList = new ArrayList<>();
    }

    public void removeListener() {
        listenersList.remove(listenersList.size() - 1);
    }

    /* public Event getState() {
        return lastEvent;
    }

    public void setState(Event lastEvent) {
        this.lastEvent = lastEvent;
    } */

}
