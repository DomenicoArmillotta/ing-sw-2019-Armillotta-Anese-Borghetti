package it.polimi.ingsw.client;

import it.polimi.ingsw.client.proxymodel.ProxyModel;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {

        public ClientHandler() {
            startClient();
        }
        public void startClient() {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            System.out.println("Client ready");
            ProxyModel proxyModel = ProxyModel.instance();
                try {
                    Socket socket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 1234);
                    executor.submit(new ClientHandlerOutput(socket));
                    executor.submit(new ClientHandlerInput(socket));
                } catch(IOException e) {
                    executor.shutdown();
                }
        }
}
