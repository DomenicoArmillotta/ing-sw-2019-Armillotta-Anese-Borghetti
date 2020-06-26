package it.polimi.ingsw.networktests;
//import org.junit.jupiter.api.Test;


import it.polimi.ingsw.server.virtualview.network.NetworkHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class NetworkHandlerTest {
    //@Test
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
    }
}
