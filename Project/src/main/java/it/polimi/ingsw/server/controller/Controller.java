package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.server.model.*;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCardParser;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EveryGodChosenEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.FailedActionEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GameStartEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GodCorrectlyChosen;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import it.polimi.ingsw.server.virtualview.network.LineClientSocketsAndPort;
import it.polimi.ingsw.server.virtualview.network.VvLobby;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private int[] userInput;
    private ActionExecutor actionExecutor = ActionExecutor.instance();
    private List<String> currentGodList = new ArrayList<>();
    private GameMaster gameMaster;
    private List<LineClientSocketsAndPort> lineClientSocketsAndPortList = new ArrayList<>();
    EventsBuffer eventsBuffer = EventsBuffer.instance();
    private boolean lineClientCtrlLock = false;

    public boolean isLineClientCtrlLock() {
        return lineClientCtrlLock;
    }

    public void setLineClientCtrlLock(boolean lineClientCtrlLock) {
        this.lineClientCtrlLock = lineClientCtrlLock;
    }

    public void setUserInput(int[] userInput) {
        this.userInput = userInput;
    }

    public void control() {
        System.out.println("In controller");
        ActionExecutor executorPointer = ActionExecutor.instance();
        //System.out.println(this.userInput[0]+" "+this.userInput[1]);
        int returnValue = executorPointer.getNextPower().doAction(this.userInput);
        System.out.println("Return value: "+returnValue);
        while(returnValue == 1) {
            returnValue = executorPointer.getNextPower().doAction(null);
            System.out.println("Return value: "+returnValue);
        }
    }

    public int loginControl(String nickName){
        VvLobby vvLobby = VvLobby.instance();
        if(vvLobby.getPlayers().isEmpty()) {
            vvLobby.setPartyOwner(nickName);
        }else
        if(!vvLobby.getPlayers().isEmpty() && vvLobby.getPlayers().contains(nickName))
            return 0;
        vvLobby.setPlayer(nickName);
        return 1;
    }

    public void setPlayerGod(String godName, String playerName) throws ParserConfigurationException, SAXException, IOException {
        ActionExecutor actionExecutor = ActionExecutor.instance();
        GodCardsDeck godCardsDeck = new GodCardsDeck();
        if(!currentGodList.contains(godName.toLowerCase())){
            EventsBuffer.instance().setLastEventBean(new FailedActionEventBean());
            return;
        }
        if(!actionExecutor.getCurrentPlayer().getPlayerGod().getGodName().toLowerCase().equals(godName.toLowerCase()) &&
           !actionExecutor.getNextPlayer().getPlayerGod().getGodName().toLowerCase().equals(godName.toLowerCase()) &&
           !actionExecutor.getPrevPlayer().getPlayerGod().getGodName().toLowerCase().equals(godName.toLowerCase())) {
            if(playerName.equals(actionExecutor.getCurrentPlayer().getName())) {
                actionExecutor.getCurrentPlayer().setPlayerGod(godCardsDeck.createGodCard(godName));
            } else if(playerName.equals(actionExecutor.getNextPlayer().getName())) {
                actionExecutor.getNextPlayer().setPlayerGod(godCardsDeck.createGodCard(godName));
            } else if(playerName.equals(actionExecutor.getPrevPlayer().getName())) {
                actionExecutor.getPrevPlayer().setPlayerGod(godCardsDeck.createGodCard(godName));
            }
        } else {
            EventsBuffer.instance().setLastEventBean(new FailedActionEventBean());
            return;
        }
        EventsBuffer.instance().setLastEventBean(new GodCorrectlyChosen(godName, playerName));
        actionExecutor.nextTurn();
        if(!actionExecutor.getCurrentPlayer().getPlayerGod().getGodName().toLowerCase().equals("") &&
           !actionExecutor.getNextPlayer().getPlayerGod().getGodName().toLowerCase().equals("") &&
           !actionExecutor.getPrevPlayer().getPlayerGod().getGodName().toLowerCase().equals(""));
        {
            EventsBuffer.instance().setLastEventBean(new EveryGodChosenEventBean());
        }
    }

    public void startGameControl() throws ParserConfigurationException, SAXException, IOException {
        List<Player> toQueuePlayerList = new ArrayList<>();
        for (int i = 0; i < VvLobby.instance().getPlayers().size(); i++) {
            toQueuePlayerList.add(new Player(VvLobby.instance().getPlayers().get(i)));
        }
        GameMaster gameMaster = new GameMaster(toQueuePlayerList,VvLobby.instance().getPlayers().size());
        this.gameMaster = gameMaster;
        gameMaster.getActionExecutor().createMap();

        if(gameMaster.getNumOfPlayers() == 1) EventsBuffer.instance().setLastEventBean(new FailedActionEventBean());
        else if(gameMaster.getNumOfPlayers() == 2) EventsBuffer.instance().setLastEventBean(new GameStartEventBean(VvLobby.instance().getPlayers().get(0),VvLobby.instance().getPlayers().get(1),VvLobby.instance().getPlayers().get(1)));
        else if(gameMaster.getNumOfPlayers() == 3) EventsBuffer.instance().setLastEventBean(new GameStartEventBean(VvLobby.instance().getPlayers().get(0),VvLobby.instance().getPlayers().get(1),VvLobby.instance().getPlayers().get(2)));

        /* gameMaster.getActionExecutor().getNextPower().doAction(null);
        System.out.println("Stampa"); */

    }

    public boolean setCurrentGodList(String god1,String god2,String god3) throws IOException, SAXException, ParserConfigurationException {
        List<String> godList = new GodCardParser().returnGodList();
        if (gameMaster.getNumOfPlayers() == 2) {
            if (godList.contains(god1) && godList.contains(god2)) {
                currentGodList.add(god1);
                currentGodList.add(god2);
                return true;
            } else {
                EventsBuffer.instance().setLastEventBean(new FailedActionEventBean());
                return false;
            }
        }
        if (gameMaster.getNumOfPlayers() == 3) {
            if (godList.contains(god1) && godList.contains(god2) && godList.contains(god3)) {
                currentGodList.add(god1);
                currentGodList.add(god2);
                currentGodList.add(god3);
                return true;
            } else {
                EventsBuffer.instance().setLastEventBean(new FailedActionEventBean());
                return false;
            }
        }
        return false;
    }

    public void addScannerInToList(LineClientSocketsAndPort lineClientSocketsAndPort){
        this.lineClientSocketsAndPortList.add(lineClientSocketsAndPort);
    }

    public synchronized void deleteElementInScannerInList(String port){
        this.lineClientSocketsAndPortList.removeIf(x -> x.getPort().equals(port));
    }

    public int getLineClientSocketsAndPortListSize() {
        return lineClientSocketsAndPortList.size();
    }
}