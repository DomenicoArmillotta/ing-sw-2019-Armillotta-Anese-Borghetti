package it.polimi.ingsw.client.proxymodel;

import it.polimi.ingsw.server.model.Worker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class GuiTest {

    public static void main(String[] args) throws InterruptedException {
        GuiDrawer guiDrawer=new GuiDrawer();
        guiDrawer.title();
        Thread.sleep(1000);
        ProxyModel.instance().setPartyOwner("marco");
        ProxyModel.instance().setThisClientNickname("marco");
        guiDrawer.login();
        Thread.sleep(1000);
        guiDrawer.drawMap();

    }
}


