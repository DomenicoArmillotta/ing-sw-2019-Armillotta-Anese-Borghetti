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
    public synchronized void promptSelectionText() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(1);
        //System.out.println("GRAPHICS_FLAG 1");
        //mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }
    /**
     *it is used to display the text indicating the information for movement in the panel
     */
    public synchronized void promptMovementText() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(2);
        //System.out.println("GRAPHICS_FLAG 2");
        //mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }
    /**
     *it is used to display the text indicating the information for build in the panel
     */
    public synchronized void promptBuildText() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(3);
        //System.out.println("GRAPHICS_FLAG 3");
        //mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    }
    /**
     *it is used to display the text indicating the information to place worker in the panel
     */
    public void promptPlaceWorkersTest() {

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(4);
        //System.out.println("GRAPHICS_FLAG 4");
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
        //System.out.println("GRAPHICS_FLAG 5");
        mapPanel.addMouseListener(display.getMouseListenerChoice());
        c.add(mapPanel);
        myFrame.setVisible(true);};

    /**
     *it is used to draw the map on which the game is developed
     */
    public synchronized void drawMap(){

        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        BoardPanel mapPanel = new BoardPanel();
        //mapPanel.setGraphicsFlag(0);
        //System.out.println("DRAW_MAP");
        mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
        //System.out.println("map drawn");
    }

    public void drawSelectWorker(Coords selectCell){};

    /**
     * it is used to display the text indicating the win in the panel
     */
    public void drawWinGame(){
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(6);
        //System.out.println("GRAPHICS_FLAG 6");
        //mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);}
    /**
     * it is used to display the text indicating the loose in the panel
     */
    public void drawLooseGame(){
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        BoardPanel mapPanel = new BoardPanel();
        mapPanel.setGraphicsFlag(7);
        //System.out.println("GRAPHICS_FLAG 7");
        //mapPanel.addMouseListener(display.getMouseListenerGame());
        c.add(mapPanel);
        myFrame.setVisible(true);
    };
    /**
     * it is used to display the text indicating the command failure in the panel
     */
    public void drawCommandFailure(String whatFailed) {
        System.out.println("\u001B[31m"+whatFailed+"\u001B[0m");

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
        //myFrame.revalidate();
        Container c = myFrame.getContentPane();
        c.removeAll();
        GodsPanel godsPanel = new GodsPanel();
        //mapPanel.setGraphicsFlag(0);
        godsPanel.addMouseListener(display.getMouseListenerGodCards());
        c.add(godsPanel);
        myFrame.setVisible(true);



        /* System.out.println("In title");
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        myFrame.removeAll();
        myFrame.repaint();
        System.out.println("Repainted"); */

        /* MyAction myAction=new MyAction();
        Display display=Display.instance();
        JPanel titlePanel = new JPanel();
        display.panels.add(titlePanel);
        titlePanel.setBackground(Color.orange);
        display.getFrame().add(titlePanel);
        display.panels.get(0).setLayout(null);
        JLabel userLabel = new JLabel("User Name");
        userLabel.setBounds(60,100,80,30);
        titlePanel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(150,100,165,25);
        display.panels.get(0).add(userText);
        final JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(170, 200, 80, 25);
        loginButton.setBackground(Color.lightGray);
        display.panels.get(0).add(loginButton);
        loginButton.addActionListener(myAction);
        display.getFrame().setVisible(true); */
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

        //System.out.println("In login");
        Display display = Display.instance();
        JFrame myFrame = display.getFrame();
        Container c = myFrame.getContentPane();
        LoginPanel loginPanel = new LoginPanel();
        // loginPanel.addMouseListener(display.getMouseListenerGame());
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
                //your actions
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
                //your actions
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
                //your actions
            }
        });
        loginPanel.add(b2);

        c.add(loginPanel);

        myFrame.setVisible(true);

        /* if(ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getPartyOwner()))
        {
            StartGame startGame=new StartGame();
            Display display=Display.instance();
            display.instance().getFrame().remove(display.panels.get(0));
            display.instance().getPanels().remove(0);
            JRadioButton jRadioButton2 = new JRadioButton();
            JRadioButton jRadioButton3 = new JRadioButton();
            jRadioButton2.setText("2 players");
            jRadioButton3.setText("3 players");
            jRadioButton2.setBackground(Color.orange);
            jRadioButton3.setBackground(Color.orange);
            JPanel loginPanel = new JPanel();
            loginPanel.add(jRadioButton2);
            loginPanel.add(jRadioButton3);
            loginPanel.setBackground(Color.orange);
            display.getFrame().add(loginPanel);
            final JButton startButton = new JButton("START GAME");
            startButton.setBounds(200, 160, 80, 25);
            startButton.setBackground(Color.lightGray);
            loginPanel.add(startButton);
            jRadioButton2.addActionListener(startGame);
            jRadioButton3.addActionListener(startGame);
            display.getFrame().setVisible(true);

        } */
    };

}
