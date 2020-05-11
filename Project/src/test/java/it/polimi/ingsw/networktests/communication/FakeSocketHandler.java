package it.polimi.ingsw.networktests.communication;

import it.polimi.ingsw.server.controller.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FakeSocketHandler implements Runnable {
    private Socket socket;
    private Controller controller;
    boolean gameRunning;
    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }
    public boolean running() {
        return gameRunning;
    }

    public FakeSocketHandler(Socket socket, Controller controller) {
        this.socket = socket;
        this.controller = controller;
    }
    public void run() {
        setGameIsRunning(true);
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner in = new Scanner(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (running()) { /* while (gameIsOn) */
                /* String inputLine;
                if(in.hasNextLine()) inputLine = in.nextLine();
                else inputLine = null; */
                /* if(inputLine.equals("quit")) {
                    status.setGameIsRunning(false);
                } else { */

                FakeCoordsEvent event = (FakeCoordsEvent) ois.readObject();
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
