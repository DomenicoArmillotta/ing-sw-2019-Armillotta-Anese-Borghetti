package it.polimi.ingsw.client.proxymodel;

import it.polimi.ingsw.client.ClientSocketManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * it is used to build the display where the size of the gui jframe is set,
 * mouse listeners are created
 */
public class Display {
    private JFrame frame;
    private static final int dimensionX = 615;
    private static final int dimensionY = 800;
    private String titleFrame;
    List<JPanel> panels;
    int graphicsFlag;
    MouseListenerGame mouseListenerGame;
    MouseListenerGodCards mouseListenerGodCards;
    MouseListenerChoice mouseListenerChoice;
    String promptText;
    int buttonAnswer = 0; /* 0 both 1 yes 2 no */

    public int getButtonAnswer() {
        return buttonAnswer;
    }

    public void setButtonAnswer(int buttonAnswer) {
        this.buttonAnswer = buttonAnswer;
    }

    public MouseListenerChoice getMouseListenerChoice() {
        return mouseListenerChoice;
    }

    public void setMouseListenerChoice(MouseListenerChoice mouseListenerChoice) {
        this.mouseListenerChoice = mouseListenerChoice;
    }


    public MouseListenerGodCards getMouseListenerGodCards() {
        return mouseListenerGodCards;
    }

    public void setMouseListenerGodCards(MouseListenerGodCards mouseListenerGodCards) {
        this.mouseListenerGodCards = mouseListenerGodCards;
    }
    /*
    public int[] getSelectableGods() {
        return selectableGods;
    }

    public void setSelectableGods(int[] selectableGods) {
        this.selectableGods = selectableGods;
    }*///*refactoring

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

    /**
     * is the constructor of the display,so
     *  sets the size of the frame and creates the Mouselisteners, which will be used in the gui
     */
    private Display(){
        this.promptText = "";
        JFrame frame = new JFrame("Santorini Board Game GUI [AM46]");
        frame.setSize(dimensionX, dimensionY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame=frame;
        List<JPanel> panels= new ArrayList();
        this.panels=panels;
        mouseListenerGame = new MouseListenerGame(ClientSocketManager.getInstance().getPrintWriter());
        mouseListenerGodCards = new MouseListenerGodCards();
        mouseListenerChoice = new MouseListenerChoice(this);

    }
    public List<JPanel> getPanels() {
        return panels;
    }
    /*
    public void addPanel(JPanel panel){
        this.panels.add(panel);
    }*///*refactoring

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
