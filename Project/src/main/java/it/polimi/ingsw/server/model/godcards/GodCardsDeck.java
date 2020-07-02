package it.polimi.ingsw.server.model.godcards;


import java.util.ArrayList;
import java.util.List;

/**
 * contains a GodCardParser and method to create a particular card
 */
public class GodCardsDeck {
    private GodCardParser godCardParser;
    private List<GodCard> inUseGodCards = new ArrayList<>();

    public GodCardsDeck() {
        this.godCardParser = new GodCardParser();
    }

    /**
     *
     * @param selectedGod god to be created
     * @return GodCard fully populated with powers
     */
    public GodCard createGodCard(String selectedGod){
        return godCardParser.selectedGodParser(selectedGod);
    }
}
