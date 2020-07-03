package it.polimi.ingsw.client.proxymodel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
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
    int clickCounter = 0;

    public MouseListenerGame(PrintWriter printWriter) {
        this.printWriter = printWriter;
        this.prevCellClickX = -1;
        this.prevCellClickY = -1;
    }

    /**
     * if the game is in the right phase,based on the click the workers of the player are positioned if you are in the setup phase,
     * after which it is used to select the worker on which to carry out the operations and select the cells on which to build, select, move
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        synchronized(Display.instance().lock) {
        clickCounter++;
        /* System.out.println("####### game click counter: "+clickCounter); */

        int x = e.getX();
        int y = e.getY();

        int firstCellX = 64;
        int firstCellY = 64;
        int shift = 118;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (x > (firstCellX + (shift * i) - (firstCellX)) && x < (firstCellX + (shift * i) + (firstCellX)))
                    if (y > (firstCellY + (shift * j) - (firstCellY)) && y < (firstCellY + (shift * j) + (firstCellY))) {
                        if (ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase().ordinal() != Phase.SETUP.ordinal()) {
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

                        } else if (ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase().ordinal() == Phase.SETUP.ordinal()) {
                            if (this.prevCellClickX == -1 && this.prevCellClickY== -1) {
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
