package it.polimi.ingsw.client.proxymodel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.BooleanEvent;
import it.polimi.ingsw.client.GameCoordsEvent;
import it.polimi.ingsw.client.SetupCoordsEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;


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

        /* System.out.println("GET PROMPT TEXT: "+Display.instance().getPromptText()); */
        if(!Display.instance().getPromptText().equals("") && x < 300 && y > 500) {
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
        } else if(!Display.instance().getPromptText().equals("")) {
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
        }


        System.out.println("MOUSE_COORDS" + x + "," + y);//these co-ords are relative to the component
        int firstCellX = 64;
        int firstCellY = 64;
        int shift = 118;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (x > (firstCellX + (shift * i) - (firstCellX)) && x < (firstCellX + (shift * i) + (firstCellX)))
                    if (y > (firstCellY + (shift * j) - (firstCellY)) && y < (firstCellY + (shift * j) + (firstCellY))) {
                        System.out.println("\u001B[32m"+"CLICKED ON CELL"+x+" "+y+"\u001B[0m");
                        //System.out.println("PH 3 CLICKED ON CELL " + i + " " + j);
                        /* this.prevCellClickX = i;
                        this.prevCellClickY = j; */
                        if (Display.instance().getPromptText().equals("") && ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase() == 3) {
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
                            System.out.println("PH 2 " + i + " " + j);
                            if (this.prevCellClickX != -1 && this.prevCellClickY!= -1 && this.prevCellClickX != x && this.prevCellClickY != y) {
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
                            this.prevCellClickX = i;
                            this.prevCellClickY = j;
                        }

                    }


            }
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
