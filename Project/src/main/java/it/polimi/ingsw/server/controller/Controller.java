package it.polimi.ingsw.server.controller;

import it.polimi.ingsw.server.model.ActionExecutor;
import it.polimi.ingsw.server.model.GameMaster;
import it.polimi.ingsw.server.model.Player;
import it.polimi.ingsw.server.model.godcards.God;
import it.polimi.ingsw.server.model.godcards.GodCardsDeck;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EveryGodChosenEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.FailedActionEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GameStartEventBean;
import it.polimi.ingsw.server.model.mvevents.eventbeans.GodCorrectlyChosen;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import it.polimi.ingsw.server.virtualview.network.VvLobby;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private int[] userInput;
    private ActionExecutor actionExecutor = ActionExecutor.instance();


    public void setUserInput(int[] userInput) {
        this.userInput = userInput;
    }

    public void control() {
        System.out.println("In controller");
        ActionExecutor executorPointer = ActionExecutor.instance();
        System.out.println(this.userInput[0]+" "+this.userInput[1]);
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
        if(!actionExecutor.getCurrentPlayer().getPlayerGod().getGodName().toLowerCase().equals(God.MORTAL.toString().toLowerCase()) &&
           !actionExecutor.getNextPlayer().getPlayerGod().getGodName().toLowerCase().equals(God.MORTAL.toString().toLowerCase()) &&
           !actionExecutor.getPrevPlayer().getPlayerGod().getGodName().toLowerCase().equals(God.MORTAL.toString().toLowerCase()))
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
        gameMaster.getActionExecutor().createMap();

        /* gameMaster.getActionExecutor().getCurrentPlayer().workersSetup(0, 0, 1, 1);
        gameMaster.getActionExecutor().getNextPlayer().workersSetup(4, 1, 2, 1);
        gameMaster.getActionExecutor().getPrevPlayer().workersSetup(1, 0, 4, 4); */
        if(gameMaster.getNumOfPlayers() == 1) EventsBuffer.instance().setLastEventBean(new FailedActionEventBean());
        else if(gameMaster.getNumOfPlayers() == 2) EventsBuffer.instance().setLastEventBean(new GameStartEventBean(VvLobby.instance().getPlayers().get(0),VvLobby.instance().getPlayers().get(1),VvLobby.instance().getPlayers().get(1)));
        else if(gameMaster.getNumOfPlayers() == 3) EventsBuffer.instance().setLastEventBean(new GameStartEventBean(VvLobby.instance().getPlayers().get(0),VvLobby.instance().getPlayers().get(1),VvLobby.instance().getPlayers().get(2)));

        /* gameMaster.getActionExecutor().getNextPower().doAction(null);
        System.out.println("Stampa"); */

    }
}