package it.polimi.ingsw.client;

import it.polimi.ingsw.model.events.Event;

import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleListernerClient {

    public class LineClient {
        private String ip;
        private int port;

        public LineClient(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }

        public void startClient() throws IOException {
            Socket socket = new Socket(ip, port);
            System.out.println("Connection established");
            ObjectOutputStream oas = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            try {
                while (true) {
                    try {
                        Event e = (Event) ois.readObject();
                        e.eventMethod();
                    }catch (ClassNotFoundException e){System.out.println("no such class "+e.getMessage());}
                }
            } catch (NoSuchElementException e) {
                System.out.println("Connection closed");
            } finally {
                oas.close();
                ois.close();
                socket.close();
            }
        }
    }

}

