package it.polimi.ingsw.client.proxymodel;

public class Player {
    private String name;


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

    private GodCards godCard;
    private WorkerClient worker1;
    private WorkerClient worker2;
}
