package it.polimi.ingsw.networktests;

import it.polimi.ingsw.client.SimpleClient;

import java.io.IOException;
import java.net.Inet4Address;

public class SimpleListenerClient3Test {
    //@Test
    public static void main(String[] args) throws IOException {
        SimpleClient simpleListenerClient = new SimpleClient(Inet4Address.getLocalHost().getHostAddress(),1234);
        simpleListenerClient.setClientID("Domenico");
        simpleListenerClient.setCurrentPlayer("Marco");
        simpleListenerClient.startClient();

    }
}