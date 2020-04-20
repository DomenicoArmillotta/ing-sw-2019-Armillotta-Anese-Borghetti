package it.polimi.ingsw;

public abstract class Power {
    int orderNumber;

    public abstract void doAction();

    public void getOrderNumber() {
    }

    public void setOrderNumber() {
    }

    ActionExecutor executorPointer;
}
