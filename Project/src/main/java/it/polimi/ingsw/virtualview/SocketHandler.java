package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.events.Event;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler implements Runnable {
    private Socket socket;
    public SocketHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            /* Scanner in = new Scanner(socket.getInputStream()); */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            PrintWriter out = new PrintWriter(socket.getOutputStream());
// Leggo e scrivo nella connessione finche' non ricevo "quit"
            while (true) { /* while (gameIsOn) */
                /* String line = in.nextLine(); */
                Event e = (Event)ois.readObject();
                if (e.equals("quit")) {
                    break;
                } else {
                    out.println("Received: " + e);
                    out.flush();
                }
            }
// Chiudo gli stream e il socket
            ois.close();
            out.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
