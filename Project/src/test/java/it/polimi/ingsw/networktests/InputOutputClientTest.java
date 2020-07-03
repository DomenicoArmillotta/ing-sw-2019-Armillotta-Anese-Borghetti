package it.polimi.ingsw.networktests;

import it.polimi.ingsw.client.ClientHandler;

import java.io.IOException;

public class InputOutputClientTest {
    public static void main(String[] args) {
        ClientHandler clientHandler = new ClientHandler("gui",1234);
        clientHandler.startClient();
    }
}
