package it.polimi.ingsw.client.proxymodel;

import it.polimi.ingsw.client.ClientSocketManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Display {
    private JFrame frame;
    private static final int dimensionX = 615;
    private static final int dimensionY = 800;
    private String titleFrame;
    List<JPanel> panels;
    int graphicsFlag;
    MouseListenerGame mouseListenerGame;
    String promptText;

    public MouseListenerGame getMouseListenerGame() {
        return mouseListenerGame;
    }

    public void setMouseListenerGame(MouseListenerGame mouseListenerGame) {
        this.mouseListenerGame = mouseListenerGame;
    }

    public int getGraphicsFlag() {
        return graphicsFlag;
    }

    public void setGraphicsFlag(int graphicsFlag) {
        this.graphicsFlag = graphicsFlag;
    }

    public void setPrompt(String promptText) {
        this.promptText = promptText;
    }

    public String getPromptText() {
        return promptText;
    }

    private Display(){
        this.promptText = "";
        JFrame frame = new JFrame("Santorini Board Game GUI [AM46]");
        frame.setSize(dimensionX, dimensionY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame=frame;
        List<JPanel> panels= new ArrayList();
        this.panels=panels;
        mouseListenerGame = new MouseListenerGame(ClientSocketManager.getInstance().getPrintWriter());
    }
    public List<JPanel> getPanels() {
        return panels;
    }
    public void addPanel(JPanel panel){
        this.panels.add(panel);
    }

    public String getTitleFrame() {
        return titleFrame;
    }

    public void setTitleFrame(String titleFrame) {
        this.titleFrame = titleFrame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }


    private static Display instance;

    public static Display instance() {
        if (instance == null) {
            instance = new Display();
        }
        return instance;
    }

}
