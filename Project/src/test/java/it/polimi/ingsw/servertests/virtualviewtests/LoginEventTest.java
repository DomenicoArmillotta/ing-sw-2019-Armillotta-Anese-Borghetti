package it.polimi.ingsw.servertests.virtualviewtests;

import it.polimi.ingsw.server.controller.Controller;
import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.virtualview.network.EventsBuffer;
import it.polimi.ingsw.server.virtualview.network.VvLobby;
import it.polimi.ingsw.server.virtualview.serverevents.LoginEvent;
import it.polimi.ingsw.server.virtualview.serverevents.ServerEvent;
import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;

public class LoginEventTest {
    @Test
    public void simpleLoginEventTest() {
        Controller dummyController = new Controller();
        EventsBuffer dummyEventBuffer = EventsBuffer.instance();
        String nickName = "Pietro";
        LoginEvent loginEvent = new LoginEvent(nickName);
        assertEquals(1,dummyController.loginControl(nickName));
        loginEvent.serverEventMethod(dummyController);
        assertNotNull(dummyEventBuffer.getLastEventBean());
    }
    @Test
    public void takenUserNameTest(){
        VvLobby.instance().getPlayers().clear();
        Controller dummyController = new Controller();
        EventsBuffer dummyEventBuffer = EventsBuffer.instance();
        VvLobby vvLobby = VvLobby.instance();
        String nickName = "Pietro";
        LoginEvent loginEvent = new LoginEvent(nickName);
        loginEvent.serverEventMethod(dummyController);
        assertNotNull(dummyEventBuffer.getLastEventBean());

        String secondNickName = "Pietro";
        LoginEvent newLoginEvent = new LoginEvent(secondNickName);
        newLoginEvent.serverEventMethod(dummyController);
        assertNotNull(dummyEventBuffer.getLastEventBean());
        assertEquals(1,vvLobby.getPlayers().size());
        assertEquals(nickName, vvLobby.getPartyOwner());
    }
    @Test
    public void correcltyInitailize3People(){
        Controller dummyController = new Controller();
        EventsBuffer dummyEventBuffer = EventsBuffer.instance();
        VvLobby vvLobby = VvLobby.instance();
        String player1 = "Pietro";
        String player2 = "Marco";
        String player3 = "Matteo";
        LoginEvent loginEvent = new LoginEvent(player1);
        loginEvent.serverEventMethod(dummyController);
        LoginEvent loginEvent1 = new LoginEvent(player2);
        loginEvent1.serverEventMethod(dummyController);
        LoginEvent loginEvent2 = new LoginEvent(player3);
        loginEvent2.serverEventMethod(dummyController);
        assertEquals(3,vvLobby.getPlayers().size());
        assertEquals(player1,vvLobby.getPartyOwner());
    }

}