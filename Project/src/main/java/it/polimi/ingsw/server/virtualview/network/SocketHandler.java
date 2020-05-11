package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.client.CoordsEvent;
import it.polimi.ingsw.server.controller.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler implements Runnable {
    private Socket socket;
    private Controller controller;
    public SocketHandler(Socket socket, Controller controller) {
        this.socket = socket;
        this.controller = controller;
    }
    public void run() {
        ServerStatus status = new ServerStatus();
        status.setGameIsRunning(true);
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner in = new Scanner(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (status.running()) {
                    CoordsEvent event = (CoordsEvent) ois.readObject();
                    int[] userInput = new int[10];
                    userInput[0] = event.getX();
                    userInput[1] = event.getY();
                    System.out.println("In socket handler");
                    controller.setUserInput(userInput);
                    controller.control();
                }
            in.close();
            oos.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
