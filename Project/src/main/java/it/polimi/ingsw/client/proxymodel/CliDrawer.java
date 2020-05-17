package it.polimi.ingsw.client.proxymodel;
import it.polimi.ingsw.client.proxymodel.ClientCell;
import it.polimi.ingsw.server.model.Worker;
import it.polimi.ingsw.server.virtualview.listeners.FailedActionListener;

import java.sql.Array;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;


public class CliDrawer extends Drawer{
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE


    void setup(ClientCell[][] map) {
        int i,j;
            //imposto tutte le celle a ground cioè 1
        for(i=0;i<7;i++){
            for(j=0;j<7;j++) {
                map[i][j].setLevel(1);
            }
        }


    }
    public void drawMap(ClientCell[][] map){
        int i,j;
        for(i=0;i<=6;i++)
            System.out.print(BLUE_BACKGROUND +" @"+RESET);
        System.out.println("");
        for(i=0;i<=4;i++){
            System.out.print(BLUE_BACKGROUND+" @"+RESET);
            for(j=0;j<5;j++){
                if(map[i][j].getLevel()==1){
                    System.out.print(GREEN_BACKGROUND+"");

                }
                else if(map[i][j].getLevel()==2){
                    System.out.print(YELLOW_BACKGROUND+"");

                }
                else if(map[i][j].getLevel()==3){
                    System.out.print(RED_BACKGROUND+"");

                }
                else if(map[i][j].getLevel()==4){
                    System.out.print(BLUE_BACKGROUND+"");

                }

                if(map[i][j].getSelectable()==1){
                    System.out.print(RED_UNDERLINED+" ");

                }
                if(map[i][j].getWorker()!=null){
                    System.out.print("0");
                }
                if(map[i][j].getWorker()==null && map[i][j].getSelectable()==0 ){
                    System.out.print("  ");
                }

            }
            System.out.print(BLUE_BACKGROUND + " @"+RESET);
            System.out.println("");
        }
        for(i=0;i<=6;i++)
            System.out.print(BLUE_BACKGROUND + " @"+RESET);
        System.out.println("");
        System.out.println("");


    };
    //mette 0 nella mappa
    public void setSelectableCell(ClientCell[][] map, List<Coords> selectableCoords){
        int l,i;
        l=selectableCoords.size();
        for(i=0;i<l;i++){
            map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(1);
        }
    }; //colora le celle che potrebbero essere selezionate

    public void setMoveWorker(ClientCell[][] map,WorkerClient selectedWorker,Coords moveCell){
        //cancello worker dalla posizione precedente
        map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].setWorker(null);
        //lo metto nella cella
        map[moveCell.getX()][moveCell.getY()].setWorker(selectedWorker);
    };
    public void setBuild(ClientCell[][] map,Coords buildCell,int levelToBuild){
        map[buildCell.getX()][buildCell.getY()].setLevel(levelToBuild);
    };

    public void drawWinGame(){
        showMessageDialog(null, "Hai vinto tutti i soldi di marco anese!!");
        System.out.println("Hai vinto tutti i soldi di marco anese!!");
    };
    public void drawLooseGame(){
        showMessageDialog(null, "Hai perso! Hai contribuito a rendere i tuoi compagni meno felici");
        System.out.println("Hai perso! Hai contribuito a rendere i tuoi compagni meno felici ");

    };
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
}
