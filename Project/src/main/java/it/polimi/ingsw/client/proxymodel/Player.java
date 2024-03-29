package it.polimi.ingsw.client.proxymodel;

/**
 * This class represents the game's Player in the client, with its name, color, godCard and workers
 * It is similar to the server's Player class, but without the model's logic
 */

public class Player {
    private String name;
    private String color;
    private GodCards godCard;
    private WorkerClient worker1;
    private WorkerClient worker2;


    public Player(String userName){
        this.name = userName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GodCards getGodCard() {
        return godCard;
    }

    public void setGodCard(GodCards godCard) {
        this.godCard = godCard;
    }

    public WorkerClient getWorker1() {
        return worker1;
    }

    public void setWorker1(WorkerClient worker1) {
        this.worker1 = worker1;
    }

    public WorkerClient getWorker2() {
        return worker2;
    }

    public void setWorker2(WorkerClient worker2) {
        this.worker2 = worker2;
    }


}
