package it.polimi.ingsw.networktests;

import it.polimi.ingsw.client.SimpleListenerClient;

import java.io.IOException;
import java.net.Inet4Address;

public class SimpleListenerClient2Test {
    //@Test
    public static void main(String[] args) throws IOException {
        SimpleListenerClient simpleListenerClient = new SimpleListenerClient(Inet4Address.getLocalHost().getHostAddress(),1234);
        simpleListenerClient.startClient();

    }
}