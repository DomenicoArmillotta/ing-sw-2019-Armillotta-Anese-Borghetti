package it.polimi.ingsw.virtualview;
import org.junit.jupiter.api.Test;


public class SimpleServerSampleTest {
    @Test
    public void simpleServerSampleTest() {
        NetworkHandler networkHandler = new NetworkHandler(1234);
        networkHandler.startServer();
    }
}
