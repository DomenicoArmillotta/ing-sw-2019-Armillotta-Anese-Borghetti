package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.model.events.Event;
import it.polimi.ingsw.model.events.WorkerSelectionEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            //ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner in = new Scanner(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
// Leggo e scrivo nella connessione finche' non ricevo "quit"
            while (true) { /* while (gameIsOn) */
                oos.writeObject(new WorkerSelectionEvent(null));
                oos.flush();
                String e = in.nextLine();
                System.out.println("OMG "+e);
                //Event e = (Event)ois.readObject();
                if (e.equals("quit")) {
                    break;
                } else {
                /* oos.writeObject(new WorkerSelectionEvent(null));
                oos.flush(); */
                }
            }
// Chiudo gli stream e il socket
            in.close();
            oos.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
