package it.polimi.ingsw.server.model.godcards;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GodCardsDeck {
    private GodCardParser godCardParser;
    private List<GodCard> inUseGodCards = new ArrayList<>();

    public GodCardsDeck() {
        this.godCardParser = new GodCardParser();
    }

    public GodCard createGodCard(String selectedGod) throws IOException, SAXException, ParserConfigurationException {
        return godCardParser.selectedGodParser(selectedGod);
    }
}
