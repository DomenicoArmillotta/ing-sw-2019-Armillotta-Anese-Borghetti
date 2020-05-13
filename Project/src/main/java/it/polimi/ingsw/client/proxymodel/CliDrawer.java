package it.polimi.ingsw.client.proxymodel;

public class CliDrawer extends Drawer{
    private final String workerSymbol="@";
    private final String colorWorker="FFFF"; //rosso
    private final String colorBoard="FFFF"; //bianco
    private final String BackgroundColorDome="ffff"; //rosso
    private final String BackgroundColorGround="ffff";//verde
    private final String BackgroundColorTop="ffff";//blue
    private final String BackgroundColorMid="ffff";//giallo
    private char board;
    private char worker;

    public void drawMap(char[][] map){
        int i,j;
        for(i=0;i<=7;i++){
            for(j=0;j<=7;j++){
                if(i<7 && i>0 && j<7 && j>0)
                    System.out.print(" ");
                if(j==7){
                    System.out.print("|");
                }
                if(j==0){
                    System.out.print("|");
                }
                if(i==7 || i==0){
                    System.out.print("_");
                }
            }
            System.out.println("");
        }

    };
    public void drawSelectableCell(int [][] selectableCell){


    };
    public  void drawMovebleCell(int [][] selectableCell){

    };
    public void drawBuildableCell(int [][] selectableCell){

    };
    //cancella il giocatore selezionato e lo riposiziona nella nuova posizione passata
    public void drawMoveWorker(WorkerClient selectedWorker,int moveX,int moveY){

    };
    //colora lo sfondo della cella che è stata selezionata
    public void drawBuildWorker(int moveX,int moveY){

    };
    //colora lo sfondo della cella che è stata selezionata
    public void drawSelectWorker(int moveX,int moveY){

    };
    public void drawWinGame(){

    };
    public void drawLooseGame(){

    };
    public void firstPlayerLogin(){

    };
    public void otherPlayersJoin(){

    };

}
