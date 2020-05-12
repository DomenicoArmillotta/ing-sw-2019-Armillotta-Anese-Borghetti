package it.polimi.ingsw.client;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    private String ip;
    private int port;

    public SimpleClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {
        ClientStatus status = new ClientStatus();
        status.setGameIsRunning(true);
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        /* ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); */
        /* ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); */
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);

        try {

            while (status.running()) {
                String inputLine = stdin.next();
                if(inputLine.equals("quit")) {
                    status.setGameIsRunning(false);
                } else {
                    if (inputLine.equals("coords")) {
                        if(stdin.hasNextInt()) {
                            int x = stdin.nextInt();
                            if (stdin.hasNextInt()) {
                                int y = stdin.nextInt();
                                System.out.println("Read coords " + x + " " + y);
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = xmlMapper.writeValueAsString(new CoordsEvent(x, y));
                                toSend+="\n";
                                printWriter.print(toSend);
                                System.out.print(toSend);
                                System.out.println("");
                                printWriter.flush();
                                System.out.println("Flushed coords " + x + " " + y);
                            }
                        }
                    } else if (inputLine.equals("string")) {
                        String stringInput = stdin.next();
                        System.out.println("Read string "+stringInput);
                        XmlMapper xmlMapper = (new XmlMapper());
                        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION,true);
                        String toSend = xmlMapper.writeValueAsString(new StringEvent(stringInput));
                        toSend+="\n";
                        printWriter.print(toSend);
                        System.out.print(toSend);
                        System.out.println("");
                        printWriter.flush();
                        System.out.println("Flushed string "+stringInput);
                    }
                }
            }
        } finally {

            /* oos.close(); */
            /* ois.close(); */
            socket.close();
        }
    }
}



