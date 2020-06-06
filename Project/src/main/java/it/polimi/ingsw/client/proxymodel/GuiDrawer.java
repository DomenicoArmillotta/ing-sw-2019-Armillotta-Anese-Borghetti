package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.ClientCell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GuiDrawer extends Drawer {

    public void setup() {};
    public void drawMap(){
        MouseListenerGame MouseListenerGame=new MouseListenerGame();
        Display display=Display.instance();
        JPanel gamePanel = new JPanel();
        gamePanel.setSize(1920,1080);
        display.getPanels().add(gamePanel);
        ImageIcon image=new ImageIcon("C:\\Users\\domen\\Desktop\\ing-sw-2019-Armillotta-Anese-Borghetti\\Project\\src\\main\\java\\it\\polimi\\ingsw\\client\\proxymodel\\SantoriniBoard.png");
        JLabel backgroundLabel = new JLabel("ciao",image,JLabel.CENTER);
        display.getFrame().setSize(1920,1080);
        backgroundLabel.setBounds(0,0,1920,1080);
        gamePanel.add(backgroundLabel);
        display.getFrame().add(gamePanel);
        gamePanel.addMouseListener(MouseListenerGame);
        display.getFrame().setVisible(true);
        



    };
    public void setSelectableCell( List<Coords> selectableCoords,int value){}; //colora le celle che potrebbero essere selezionate
    public void setMoveWorker(WorkerClient selectedWorker,Coords moveCell){};
    public void setBuild(Coords buildCell,int levelToBuild){};
    public void setIsSelected(WorkerClient selectedWorker){};
    public void drawSelectWorker(Coords selectCell){};
    public void drawWinGame(){};
    public void drawLooseGame(){};
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
    public void createPlayer(String name){};
    public void createWorker1(Player player,Coords startCoords,int index){};
    public void createWorker2(Player player,Coords startCoords,int index){};
    public void title(){
        MyAction myAction=new MyAction();
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
        display.getFrame().setVisible(true);
    }
    public void login(){

        if(ProxyModel.instance().getThisClientNickname().equals(ProxyModel.instance().getPartyOwner()))
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

        }
    };

}
