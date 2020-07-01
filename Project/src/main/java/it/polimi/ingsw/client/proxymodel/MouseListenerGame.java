package it.polimi.ingsw.client.proxymodel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.BooleanEvent;
import it.polimi.ingsw.client.ClientSocketManager;
import it.polimi.ingsw.client.GameCoordsEvent;
import it.polimi.ingsw.client.SetupCoordsEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;

/**
 * it is used to play in the game, ie select the cells where you want to move, build and which worker to select.
 * it is also used to select cells where you want to place workers at the start of the game
 */
public class MouseListenerGame implements MouseListener {
    PrintWriter printWriter;
    int prevCellClickX;
    int prevCellClickY;

    public MouseListenerGame(PrintWriter printWriter) {
        this.printWriter = printWriter;
        this.prevCellClickX = -1;
        this.prevCellClickY = -1;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        /* if((Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals("")) &&  ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) ) {

            System.out.println("Clicked with MouseListenerChoice");
            PrintWriter printWriter = ClientSocketManager.getInstance().getPrintWriter();
            XmlMapper xmlMapper = (new XmlMapper());
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            if(x < 300 && y > 500) {
                System.out.println("\u001B[32m"+"CLICKED ON BUTTON YES"+x+" "+y+"\u001B[0m");
                Display.instance().setPrompt("");
                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                String toSend = null;
                try {
                    toSend = xmlMapper.writeValueAsString(new BooleanEvent(true));
                } catch (JsonProcessingException jsonProcessingException) {
                    jsonProcessingException.printStackTrace();
                }
                toSend += "\n";
                printWriter.print(toSend);
                printWriter.flush();
                System.out.println("yes");

            } else if(y > 500) { // (Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals(""))
                System.out.println("\u001B[32m"+"CLICKED ON BUTTON NO"+x+" "+y+"\u001B[0m");
                Display.instance().setPrompt("");
                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                String toSend = null;
                try {
                    toSend = xmlMapper.writeValueAsString(new BooleanEvent(false));
                } catch (JsonProcessingException jsonProcessingException) {
                    jsonProcessingException.printStackTrace();
                }
                toSend += "\n";
                printWriter.print(toSend);
                printWriter.flush();
                System.out.println("no");
            }

        } else { */

            //System.out.println("MOUSE_COORDS" + x + "," + y);//these co-ords are relative to the component
            //System.out.println(ProxyModel.instance().getTurn().getCurrentPlayer().getName());

            int firstCellX = 64;
            int firstCellY = 64;
            int shift = 118;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++) {
                    if (x > (firstCellX + (shift * i) - (firstCellX)) && x < (firstCellX + (shift * i) + (firstCellX)))
                        if (y > (firstCellY + (shift * j) - (firstCellY)) && y < (firstCellY + (shift * j) + (firstCellY))) {
                            //System.out.println("\u001B[32m"+"CLICKED ON CELL"+x+" "+y+"\u001B[0m");
                            if (ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase() != 2) {
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = null;
                                try {
                                    toSend = xmlMapper.writeValueAsString(new GameCoordsEvent(i, j));
                                } catch (JsonProcessingException jsonProcessingException) {
                                    jsonProcessingException.printStackTrace();
                                }
                                toSend += "\n";
                                printWriter.print(toSend);
                                printWriter.flush();

                            } else if (ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase() == 2) {
                                //System.out.println("PH 2 " + i + " " + j);

                                if (this.prevCellClickX == -1 && this.prevCellClickY== -1) {
                                    //System.out.println("First worker setup");
                                    XmlMapper xmlMapper = (new XmlMapper());
                                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                    String toSend = null;
                                    try {
                                        toSend = xmlMapper.writeValueAsString(new SetupCoordsEvent(prevCellClickX, prevCellClickY, i, j));
                                    } catch (JsonProcessingException jsonProcessingException) {
                                        jsonProcessingException.printStackTrace();
                                    }
                                    toSend += "\n";
                                    printWriter.print(toSend);
                                    printWriter.flush();
                                    this.prevCellClickX = i;
                                    this.prevCellClickY = j;
                                } else if (this.prevCellClickX != -1 && this.prevCellClickY!= -1 && this.prevCellClickX != x && this.prevCellClickY != y) {
                                    System.out.println("Second worker setup");
                                    XmlMapper xmlMapper = (new XmlMapper());
                                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                    String toSend = null;
                                    try {
                                        toSend = xmlMapper.writeValueAsString(new SetupCoordsEvent(prevCellClickX, prevCellClickY, i, j));
                                    } catch (JsonProcessingException jsonProcessingException) {
                                        jsonProcessingException.printStackTrace();
                                    }
                                    toSend += "\n";
                                    printWriter.print(toSend);
                                    printWriter.flush();
                                }
                            }
                        }
                }

        //}

        /* System.out.println("GET PROMPT TEXT: "+Display.instance().getPromptText()); */
        /* if((Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals("")) && x < 300 && y > 500) {
            System.out.println("\u001B[32m"+"CLICKED ON BUTTON YES"+x+" "+y+"\u001B[0m");
            Display.instance().setPrompt("");
            XmlMapper xmlMapper = (new XmlMapper());
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            String toSend = null;
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(true));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
            toSend += "\n";
            printWriter.print(toSend);
            printWriter.flush();
            System.out.println("yes");
        } else if((Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals(""))) { // (Display.instance().getGraphicsFlag() == 5)&&(!Display.instance().getPromptText().equals(""))
            System.out.println("\u001B[32m"+"CLICKED ON BUTTON NO"+x+" "+y+"\u001B[0m");
            Display.instance().setPrompt("");
            XmlMapper xmlMapper = (new XmlMapper());
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            String toSend = null;
            try {
                toSend = xmlMapper.writeValueAsString(new BooleanEvent(false));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
            toSend += "\n";
            printWriter.print(toSend);
            printWriter.flush();
            System.out.println("no");
        } */



    }

    private int abs(int i) {
        if(i < 0) i*=-1;
        return i;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
