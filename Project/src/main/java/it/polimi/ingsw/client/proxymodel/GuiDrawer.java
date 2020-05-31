package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.ClientCell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiDrawer extends Drawer {

    public void setup() {};
    public void drawMap(){};
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
    public void login(){
        ActionListener actionListener1= new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawMap();
            }
        };
        JFrame frame = new JFrame("LOGIN");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        frame.add(panel);
        frame.setVisible(true);
        ////////////////
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User Name");
        userLabel.setBounds(10,40,80,30);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,40,165,25);
        panel.add(userText);
        final JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(120, 100, 80, 25);
        loginButton.setBackground(Color.lightGray);
        panel.add(loginButton);
        loginButton.addActionListener(actionListener1);
    }
}
