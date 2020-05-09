package it.polimi.ingsw.virtualview;

import it.polimi.ingsw.client.ClientEvent;
import it.polimi.ingsw.client.ClientStatus;
import it.polimi.ingsw.client.CoordsEvent;
import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.model.GameMaster;
import it.polimi.ingsw.model.GodCardParser.God;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.events.Event;
import it.polimi.ingsw.model.events.WorkerSelectionEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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

            while (status.running()) { /* while (gameIsOn) */
                /* String inputLine;
                if(in.hasNextLine()) inputLine = in.nextLine();
                else inputLine = null; */
                /* if(inputLine.equals("quit")) {
                    status.setGameIsRunning(false);
                } else { */
                    CoordsEvent event = (CoordsEvent) ois.readObject();
                    int[] userInput = new int[10];
                    userInput[0] = event.getX();
                    userInput[1] = event.getY();
                    System.out.println("In socket handler");
                    controller.setUserInput(userInput);
                    controller.control();
                    /* oos.writeObject(new WorkerSelectionEvent(null));
                    oos.flush(); */
                    /* String inputLine = in.nextLine(); */
                    /* oos.writeObject(new WorkerSelectionEvent(null));
                    oos.flush();
                    SelectedWorkerEvent event = (SelectedWorkerEvent) ois.readObject();
                    //Event e = (Event)ois.readObject();
                    if (event.getX() == 5) {
                        break;
                    } else { */
                /* oos.writeObject(new WorkerSelectionEvent(null));
                oos.flush(); */
                    /* } */
                }
// Chiudo gli stream e il socket
            in.close();
            oos.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
