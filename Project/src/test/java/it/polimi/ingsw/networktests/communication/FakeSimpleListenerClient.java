package it.polimi.ingsw.networktests.communication;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FakeSimpleListenerClient {

    private String ip;
    private int port;

    boolean gameRunning;

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public boolean running() {
        return gameRunning;
    }

    public FakeSimpleListenerClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {
        setGameIsRunning(true);
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);
        try {
            while (running()) {
                String inputLine = stdin.nextLine();
                if(inputLine.equals("quit")) {
                    setGameIsRunning(false);
                } else {
                    if (inputLine.equals("coords")) {
                        oos.writeObject(new FakeCoordsEvent(stdin.nextInt(), stdin.nextInt()));
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



