package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.virtualview.listeners.NoUpdatesListener;

import java.util.ArrayList;
import java.util.List;

public class EventsBuffer {
    List<EventBean> eventBeans;
    boolean endGame = false;
    private boolean sendEventBeanLock = true;
    public Object brdLock = new Object();

    private static EventsBuffer instance;

    public synchronized static EventsBuffer instance() {
        if (instance == null) {
            instance = new EventsBuffer();
        }
        return instance;
    }

    private EventsBuffer() {
        List<EventBean> eventBeans = new ArrayList<>();
        this.eventBeans = eventBeans;
    }

    public void setLastEventBean(EventBean lastEventBean) {
        System.out.println("In event buffer: "+lastEventBean);
        eventBeans.add(0, lastEventBean);
    }

    public EventBean getLastEventBean() {
        EventBean lastEventBean = eventBeans.get(eventBeans.size()-1);
        eventBeans.remove(eventBeans.size()-1);
        System.out.println("Last Event Bean getted: "+lastEventBean+" current eventBeans: "+ eventBeans);
        return lastEventBean;
    }

    public boolean emptyBuffer() {
        if(eventBeans.size() == 0)
            return true;
        else return false;
    }

    public void flushBuffer() {
        eventBeans.clear();
    }

    public synchronized void setEndGame() {
        this.endGame = true;
    }

    public synchronized boolean getEndGame() {
        return endGame;
    }

    public void setNotEndGame(){
        this.endGame = false;
    }

    public boolean isSendEventBeanLock() {
        return sendEventBeanLock;
    }

    public void setSendEventBeanLock(boolean sendEventBeanLock) {
        this.sendEventBeanLock = sendEventBeanLock;
    }
}
