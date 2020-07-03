package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;


import java.util.ArrayList;
import java.util.List;

/**
 * list of event that the server need to sends to all the clients.
 * contains a list of EventBeans, two locks and a endGame that contain the status of the current game.
 * endGame == true, the game is ended else the game is still going.
 */

public class EventsBuffer {
    List<EventBean> eventBeans;
    boolean endGame = false;
    private boolean sendEventBeanLock = true;
    public final Object brdLock = new Object();

    private static EventsBuffer instance;

    public static EventsBuffer instance() {
        if (instance == null) {
            instance = new EventsBuffer();
        }
        return instance;
    }

    private EventsBuffer() {
        List<EventBean> eventBeans = new ArrayList<>();
        this.eventBeans = eventBeans;
    }
    /**
     * push an eventBean to the top of EventBeans list.
     * @param lastEventBean last bean created by the server and pushed on top of EvenBeans list
     */
    public void setLastEventBean(EventBean lastEventBean) {
        System.out.println("In event buffer: "+lastEventBean);
        eventBeans.add(0, lastEventBean);
    }

    /**
     * pop the top element of EventBeans
     * @return last pushed eventBeans
     */
    public EventBean getLastEventBean() {
        synchronized (eventBeans) {
            EventBean lastEventBean = eventBeans.get(eventBeans.size() - 1);
            if (eventBeans.size() > 0) {
                eventBeans.remove(eventBeans.size() - 1);
            }
            System.out.println("Last Event Bean getted: " + lastEventBean + " current eventBeans: " + eventBeans);
            return lastEventBean;
        }
    }
    /**
     * return true if EventBeans is empty
     * @return true if is empty else false
     */
    public boolean emptyBuffer() {
        if(eventBeans.size() == 0)
            return true;
        else return false;
    }

    /**
     * flush eventBeans list
     */
    public void flushBuffer() {
        eventBeans.clear();
    }

    /**
     * set endGame to true
     */
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
