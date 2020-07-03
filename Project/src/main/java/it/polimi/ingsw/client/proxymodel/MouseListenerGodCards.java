package it.polimi.ingsw.client.proxymodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.ClientSocketManager;
import it.polimi.ingsw.client.GodChoiceEvent;
import it.polimi.ingsw.client.GodListEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.serve to let the partyOwner select the gods that all players can use in the game
 * 2.Each player selects the god he wants to use in the game
 */
public class MouseListenerGodCards implements MouseListener {
    List<String> selectableGods = new ArrayList<>();
    int clickCounter = 0;

    public void setSelectableGods(List<String> selectableGods) {
        this.selectableGods = selectableGods;
    }

    /**
     * it associates to each card a coordinate based on the position in the drawing of the gui
     * @return the position of the cards selected by the party owner
     */
    public List<Coords> getSelectableGods() {
        List<Coords> cardCoords = new ArrayList<>();
        for (int i = 0; i < selectableGods.size(); i++) {
            switch (selectableGods.get(i)) {
                case "apollo":
                    cardCoords.add(new Coords(0, 0));
                    break;
                case "atlas":
                    cardCoords.add(new Coords(0, 1));
                    break;
                case "minotaur":
                    cardCoords.add(new Coords(0, 2));
                    break;
                case "artemis":
                    cardCoords.add(new Coords(1, 0));
                    break;
                case "demeter":
                    cardCoords.add(new Coords(1, 1));
                    break;
                case "pan":
                    cardCoords.add(new Coords(1, 2));
                    break;
                case "athena":
                    cardCoords.add(new Coords(2, 0));
                    break;
                case "hephaestus":
                    cardCoords.add(new Coords(2, 1));
                    break;
                case "prometheus":
                    cardCoords.add(new Coords(2, 2));
                    break;

            }
        }
        return cardCoords;
    }

    /**
     *
     * if the game is in the right phase, that is to select the gods, then the party owner can select the gods that can be used in the game,
     * after  he and the other players can select their god to associate with their workers.
     * Based on the position of the mouse click you understand that god has been selected
     * once selected the gods send everything to the server
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        synchronized(Display.instance().lock) {
            clickCounter++;
            /* System.out.println("####### cards click counter: "+clickCounter); */
            int x = e.getX();
            int y = e.getY();
            PrintWriter printWriter = ClientSocketManager.getInstance().getPrintWriter();
            String godName = null;
            int firstCellX = 80 + 840 / 12; // 150
            int firstCellY = 5 + 1410 / 12; // 122.5
            int shiftX = 840 / 6;
            int shiftY = 1410 / 6;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (x > (firstCellX + (shiftX * i) - (shiftX / 2)) && x < (firstCellX + (shiftX * i) + (shiftX / 2))) {
                        if (y > (firstCellY + (shiftY * j) - (shiftY / 2)) && y < (firstCellY + (shiftY * j) + (shiftY / 2))) {
                            //System.out.println("clicked on card: " + i + " " + j + " (" + x + " " + y + ")");
                            switch (i) {
                                case 0:
                                    switch (j) {
                                        case 0:
                                            godName = "apollo";
                                            break;
                                        case 1:
                                            godName = "atlas";
                                            break;
                                        case 2:
                                            godName = "minotaur";
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (j) {
                                        case 0:
                                            godName = "artemis";
                                            break;
                                        case 1:
                                            godName = "demeter";
                                            break;
                                        case 2:
                                            godName = "pan";
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (j) {
                                        case 0:
                                            godName = "athena";
                                            break;
                                        case 1:
                                            godName = "hephaestus";
                                            break;
                                        case 2:
                                            godName = "prometheus";
                                            break;
                                    }
                                    break;
                            }
                            //System.out.println(ProxyModel.instance().getPhase()+" "+godName);
                            if (ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase().ordinal() == Phase.OWNER_GOD_CHOICE.ordinal() && !selectableGods.contains(godName)) { /* fase di selezione delle carte del party owner */
                                //System.out.println(".-.-.-.");
                                selectableGods.add(godName);
                                if (selectableGods.size() == ProxyModel.instance().getPlayers().size()) {
                                    XmlMapper xmlMapper = (new XmlMapper());
                                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                    String toSend = null;
                                    if (ProxyModel.instance().getPlayers().size() == 2) {
                                        try {
                                            toSend = xmlMapper.writeValueAsString(new GodListEvent(selectableGods.get(0), selectableGods.get(1), ""));
                                        } catch (JsonProcessingException jsonProcessingException) {
                                            jsonProcessingException.printStackTrace();
                                        }
                                    } else {
                                        try {
                                            toSend = xmlMapper.writeValueAsString(new GodListEvent(selectableGods.get(0), selectableGods.get(1), selectableGods.get(2)));
                                        } catch (JsonProcessingException jsonProcessingException) {
                                            jsonProcessingException.printStackTrace();
                                        }
                                    }
                                    toSend += "\n";
                                    printWriter.print(toSend);
                                    printWriter.flush();
                                    //System.out.println("FLUSHED GODS PARTY OWNER: "+toSend);
                                }
                            } else if (ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getTurn().getCurrentPlayer().getName()) && ProxyModel.instance().getPhase().ordinal() != Phase.OWNER_GOD_CHOICE.ordinal()) {
                                //Display.instance().setClicked(0);
                                //System.out.println("EUREKA");
                                XmlMapper xmlMapper = (new XmlMapper());
                                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                                String toSend = null;
                                try {
                                    toSend = xmlMapper.writeValueAsString(new GodChoiceEvent(godName, ProxyModel.instance().getThisClientNickname()));
                                } catch (JsonProcessingException jsonProcessingException) {
                                    jsonProcessingException.printStackTrace();
                                }
                                toSend += "\n";
                                printWriter.print(toSend);
                                printWriter.flush();
                                //System.out.println("FLUSHED GOD CHOICE EVENT");
                            }

                        }
                    }
                }
            }


        /*

        for(int i = 0; i < 3; i++) {
            g.drawImage(imgArray[i], 80+i*140, 5, 840/6, 1410/6, null);
        }
        for(int i = 0; i < 3; i++) {
            g.drawImage(imgArray[i+3], 80+i*140, 235+5, 840/6, 1410/6, null);
        }
        for(int i = 0; i < 3; i++) {
            g.drawImage(imgArray[i+6], 80+i*140, 2*235+5, 840/6, 1410/6, null);
        }

         */


        }

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
