package it.polimi.ingsw.client.proxymodel;

public abstract class Drawer {
    public void drawMap(char[][] map){};
    public void drawSelectableCell(int [][] selectableCell){}; //colora le celle che potrebbero essere selezionate
    public  void drawMovebleCell(int [][] selectableCell){};
    public void drawBuildableCell(int [][] selectableCell){};
    public void drawMoveWorker(WorkerClient selectedWorker,int moveX,int moveY){};
    public void drawBuildWorker(int moveX,int moveY){};
    public void drawSelectWorker(int moveX,int moveY){};
    public void drawWinGame(){};
    public void drawLooseGame(){};
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
}
