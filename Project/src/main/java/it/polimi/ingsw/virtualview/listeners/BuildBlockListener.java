package it.polimi.ingsw.virtualview.listeners;

import it.polimi.ingsw.model.events.BuildBlockEvent;

public class BuildBlockListener implements Listener {

    private static BuildBlockListener instance;

    public static BuildBlockListener instance() {
        if (instance == null) {
            instance = new BuildBlockListener();
        }
        return instance;
    }

    public void buildBlock(BuildBlockEvent buildBlockEvent) {
        /* send event to clients */
    }

}
