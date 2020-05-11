package it.polimi.ingsw.networktests.communication;
import java.io.IOException;
import java.net.Inet4Address;

public class FakeClient {
    public static void main(String[] args) throws IOException {
        FakeSimpleListenerClient fakeSimpleListenerClient = new FakeSimpleListenerClient(Inet4Address.getLocalHost().getHostAddress(),1234);
        fakeSimpleListenerClient.startClient();

    }
}
