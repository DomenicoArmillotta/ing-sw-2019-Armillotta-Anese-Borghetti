package it.polimi.ingsw.networktests;
import it.polimi.ingsw.server.virtualview.network.NetworkHandler;
import org.junit.jupiter.api.Test;


public class SimpleServerSampleTest {
    @Test
    public void simpleServerSampleTest() {
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
    }
}
