package it.polimi.ingsw.client;

import org.junit.Test;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleListenerClientTest {
    //@Test
    public static void main(String[] args) throws IOException {
        SimpleListenerClient simpleListenerClient = new SimpleListenerClient(Inet4Address.getLocalHost().getHostAddress(),1234);
        simpleListenerClient.startClient();

    }
}