package it.polimi.ingsw.client.proxymodel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.LoginEvent;
import it.polimi.ingsw.client.StartUpEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.List;

/**
 *this function sets the flags in order to understand in drawing mode what to draw when certain events are triggered
 *it also sends the data, i.e. the name and number of players when the preset buttons are pressed
 */
public class GuiDrawer extends Drawer {
    String name;

    /**
     *it is used to display the text indicating the information for selection in the panel
     */
    public void promptSelectionText() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(1);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }
    /**
     *it is used to display the text indicating the information for movement in the panel
     */
    public void promptMovementText() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(2);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }
    /**
     *it is used to display the text indicating the information for build in the panel
     */
    public void promptBuildText() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(3);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }
    /**
     *it is used to display the text indicating the information to place worker in the panel
     */
    public void promptPlaceWorkersTest() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(4);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);};
    /**
     *it is used to display the text indicating the info to make a choice in the panel
     */
    public void promptChoice(String promptText) {

        Display display = Display.instance();
        display.setButtonAnswer(0);
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setPrompt(promptText);
        mapPanel.setGraphicsFlag(5);
        mapPanel.addMouseListener(display.getMouseListenerChoice());
        c.add(mapPanel);
        myFrame.setVisible(true); };

    /**
     *it is used to draw the map on which the game is developed
     */
    public void drawMap(){
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }

    public void drawSelectWorker(Coords selectCell){};

    /**
     * it is used to display the text indicating the win in the panel
     */
    public void drawWinGame(){
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(6);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);}
    /**
     * it is used to display the text indicating the loose in the panel
     */
    public void drawLooseGame(){
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(7);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    };
    /**
     * it is used to display the text indicating the command failure in the panel
     */
    public void drawCommandFailure(String whatFailed) {
        Display display = Display.instance();
        display.setButtonAnswer(0);
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setCommandFailure(whatFailed);
        mapPanel.setGraphicsFlag(8);
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);

    }

    /**
     * it is used to display the text indicating the gods chosen by the party owner in the panel
     * @param godList gods chosen by party owner
     */
    @Override
    public void drawPartyOwnerGodChoices(List<String> godList) {
        Display.instance().getMouseListenerGodCards().setSelectableGods(godList);
    }

    /**
     * create a display instance and create the jpanel with the mouselistener
     * where the choice of the gods will take place
     */
    public void title(){

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        GodsPanel godsPanel = new GodsPanel();
        godsPanel.addMouseListener(display.getMouseListenerGodCards());
        c.add(godsPanel);
        myFrame.setVisible(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * create a display instance and create the jpanel with the mouselistener,
     * where the buttons are positioned to select how many players you are in the game,
     * with the login button and a textbox where you can enter your username
     *
     *once you click on the login button, or if you are the party owner,
     *the players button you perform an action that sends the data respectively
     */
    public void login() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        LoginPanel loginPanel = new LoginPanel();
        Font font = new Font("Serif", Font.PLAIN, 24);

        Font fontButton = new Font("Serif", Font.PLAIN, 22);
        JTextField textField = new JTextField(20);
        textField.setFont(font);
        loginPanel.add(textField);
        JButton b = new JButton("LOGIN");
        JButton b1 = new JButton("2 PLAYERS");
        JButton b2 = new JButton("3 PLAYERS");
        b.setFont(fontButton);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(ProxyModel.instance().getPlayers().size()<3) {
                    setName(textField.getText());
                    ProxyModel.instance().setThisClientNickname(getName());
                    PrintWriter printWriter = Display.instance().getMouseListenerGame().printWriter;
                    XmlMapper xmlMapper = (new XmlMapper());
                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                    String toSend = null;
                    try {
                        toSend = xmlMapper.writeValueAsString(new LoginEvent(name));
                    } catch (JsonProcessingException jsonProcessingException) {
                        jsonProcessingException.printStackTrace();
                    }
                    toSend += "\n";
                    printWriter.print(toSend);
                    printWriter.flush();
                }
            }
        });
        loginPanel.add(b);

        JLabel lblWelcome = new JLabel("<html><br/><br/>", SwingConstants.CENTER);
        loginPanel.add(lblWelcome);


        b1.setFont(fontButton);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter printWriter = Display.instance().getMouseListenerGame().printWriter;
                XmlMapper xmlMapper = (new XmlMapper());
                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                String toSend = null;
                try {
                    toSend = xmlMapper.writeValueAsString(new StartUpEvent(ProxyModel.instance().getThisClientNickname(),"2"));
                } catch (JsonProcessingException jsonProcessingException) {
                    jsonProcessingException.printStackTrace();
                }
                toSend += "\n";
                printWriter.print(toSend);
                printWriter.flush();
                printWriter.flush();
            }
        });
        loginPanel.add(b1);

        b2.setFont(fontButton);
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter printWriter = Display.instance().getMouseListenerGame().printWriter;
                XmlMapper xmlMapper = (new XmlMapper());
                xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                String toSend = null;
                try {
                    toSend = xmlMapper.writeValueAsString(new StartUpEvent(ProxyModel.instance().getThisClientNickname(),"3"));
                } catch (JsonProcessingException jsonProcessingException) {
                    jsonProcessingException.printStackTrace();
                }
                toSend += "\n";
                printWriter.print(toSend);
                printWriter.flush();
                printWriter.flush();
            }
        });
        loginPanel.add(b2);

        c.add(loginPanel);

        myFrame.setVisible(true);
    };

}
