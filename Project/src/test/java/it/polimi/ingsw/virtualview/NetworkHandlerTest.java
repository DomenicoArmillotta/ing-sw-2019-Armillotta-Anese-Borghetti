package it.polimi.ingsw.virtualview;
import org.junit.jupiter.api.Test;


public class NetworkHandlerTest {
    @Test
    public void networkHandlerTest() {
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
    }
}
