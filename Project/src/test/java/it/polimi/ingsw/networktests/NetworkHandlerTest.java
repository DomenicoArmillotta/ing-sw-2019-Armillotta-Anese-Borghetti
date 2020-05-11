package it.polimi.ingsw.networktests;
//import org.junit.jupiter.api.Test;


import it.polimi.ingsw.server.virtualview.network.NetworkHandler;

public class NetworkHandlerTest {
    //@Test
    public static void main(String[] args) {
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
    }
}
