package it.polimi.ingsw.networktests;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class SimpleServerSampleTest {
    @Test
    public void simpleServerSampleTest() throws IOException, SAXException, ParserConfigurationException {
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
    }
}
