package it.polimi.ingsw.client.viewevents;
import it.polimi.ingsw.client.proxymodel.Phase;
import it.polimi.ingsw.client.proxymodel.ProxyModel;
import java.util.Arrays;

/**
 * used for show the gods chosen by party owner
 */
public class CorrectlyChoseGodListViewEvent extends ViewEvent{
    private String god1;
    private String god2;
    private String god3;

    public CorrectlyChoseGodListViewEvent(String god1, String god2, String god3) {
        this.god1 = god1;
        this.god2 = god2;
        this.god3 = god3;
    }

    /**
     * when the party owner chooses the gods this works on the screen shows the gods that can be used in the game
     */
    @Override
    public void viewEventMethod() {
        ProxyModel.instance().setPhase(Phase.PLAYER_GOD_CHOICE);
        ProxyModel.instance().getDrawerStrategy().drawPartyOwnerGodChoices(Arrays.asList(god1,god2,god3));
        ProxyModel.instance().getDrawerStrategy().title();
    }
}
