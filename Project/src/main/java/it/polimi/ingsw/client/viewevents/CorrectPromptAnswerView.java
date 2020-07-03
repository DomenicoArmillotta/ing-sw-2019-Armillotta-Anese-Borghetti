package it.polimi.ingsw.client.viewevents;
import it.polimi.ingsw.client.proxymodel.ProxyModel;
/**
 * shows on screen the answer given by the player at a choice prompt
 */
public class CorrectPromptAnswerView extends ViewEvent {
    @Override
    public void viewEventMethod() {
        //System.out.println("In CorrectPromptAnswerView");
        ProxyModel.instance().getDrawerStrategy().drawMap();
    }
}
