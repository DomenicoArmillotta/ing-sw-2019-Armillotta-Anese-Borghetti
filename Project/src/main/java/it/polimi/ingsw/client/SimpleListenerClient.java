package it.polimi.ingsw.client;

import it.polimi.ingsw.model.events.Event;

import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleListenerClient {

    private String ip;
    private int port;

    public SimpleListenerClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        ObjectOutputStream oas = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        try {
            while (true) {
                Event e = (Event) ois.readObject();
                e.eventMethod();
                System.out.println(e);
                String toSend = "banana";
                printWriter.println(toSend);
                printWriter.flush();
            }
        } catch (NoSuchElementException | ClassNotFoundException e) {
            System.out.println("Connection closed");
        } finally {
            oas.close();
            ois.close();
            socket.close();
        }
    }
}



