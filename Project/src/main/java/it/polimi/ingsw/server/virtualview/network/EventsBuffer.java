package it.polimi.ingsw.server.virtualview.network;

import it.polimi.ingsw.server.model.mvevents.eventbeans.EventBean;
import it.polimi.ingsw.server.virtualview.listeners.NoUpdatesListener;

import java.util.ArrayList;
import java.util.List;

public class EventsBuffer {
    List<EventBean> eventBeans;
    boolean waiting;

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

    public void setLastEventBean(EventBean lastEventBean) {
        eventBeans.add(0, lastEventBean);
    }

    public EventBean getLastEventBean() {
        EventBean lastEventBean = eventBeans.get(eventBeans.size()-1);
        eventBeans.remove(eventBeans.size()-1);
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

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean isWaiting() {
        return waiting;
    }
}
