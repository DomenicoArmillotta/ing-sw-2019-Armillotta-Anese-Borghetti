package it.polimi.ingsw.client;

import java.io.PrintWriter;
import java.util.Scanner;

public class ClientSocketManager {

    private PrintWriter printWriter;
    private Scanner scannerIn;

    private static ClientSocketManager instance;

    public static ClientSocketManager getInstance() {
        if(instance == null) {
            instance = new ClientSocketManager();
        }
        return instance;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public Scanner getScannerIn() {
        return scannerIn;
    }

    public void setScannerIn(Scanner scannerIn) {
        this.scannerIn = scannerIn;
    }
}
