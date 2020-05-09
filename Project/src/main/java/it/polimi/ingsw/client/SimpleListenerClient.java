package it.polimi.ingsw.client;

import it.polimi.ingsw.model.events.Event;
import it.polimi.ingsw.model.events.WorkerSelectionEvent;

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
        ClientStatus status = new ClientStatus();
        status.setGameIsRunning(true);
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);
        try {
            while (status.running()) {
                String inputLine = stdin.nextLine();
                if(inputLine.equals("quit")) {
                    status.setGameIsRunning(false);
                } else {
                    if (inputLine.equals("coords")) {
                        oos.writeObject(new CoordsEvent(stdin.nextInt(), stdin.nextInt()));
                        oos.flush();
                        System.out.println("Flushed");
                    } else if (inputLine.equals("string")) {
                        /* oos.writeObject(new CoordsEvent(stdin.nextInt(), stdin.nextInt()));
                        oos.flush();
                        System.out.println("Flushed"); */
                    }
                    //Event event = (Event) ois.readObject();
                    //event.eventMethod();
                }
            }
        } finally {
            oos.close();
            ois.close();
            socket.close();
        }
    }
}



