package it.polimi.ingsw.client.proxymodel;

import java.util.List;

/**
 * This is the abstract strategy of the client's drawers, that can concretely be CLI or GUI Drawer
 */

public abstract class Drawer {

    public void drawMap(){};
    public void drawWinGame(){};
    public void drawLooseGame(String loser){};
    public void title(){};
    public void login(){};
    public void promptSelectionText(){};
    public void promptMovementText(){};
    public void promptBuildText(){};
    public void promptPlaceWorkersTest(){};
    public void promptChoice(String promptText){};
    public void drawConnectionInterrupt(){}
    public void drawPartyOwnerGodChoices(List<String> godList){}
    public void drawFailedAction(){}
    public void drawCommandFailure(String whatFailed){}


}
