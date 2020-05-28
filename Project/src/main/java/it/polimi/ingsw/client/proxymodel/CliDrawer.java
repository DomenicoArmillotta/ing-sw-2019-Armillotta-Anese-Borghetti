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


    public void setup() {
        ClientCell[][] map=ProxyModel.instance().getMap();
        int i,j;
            //imposto tutte le celle a ground cioè 1
        for(i=0;i<=4;i++){
            for(j=0;j<=4;j++) {
                map[i][j].setLevel(0);
            }
        }
    }
    public void drawMap(){
        Player player1;
        Player player2;
        Player player3;

        if(ProxyModel.instance().getPlayers().size() == 2) {
            player1 = ProxyModel.instance().getPlayers().get(0);
            player2 = ProxyModel.instance().getPlayers().get(1);
            player3 = null;
        } else {
            player1 = ProxyModel.instance().getPlayers().get(0);
            player2 = ProxyModel.instance().getPlayers().get(1);
            player3 = ProxyModel.instance().getPlayers().get(2);
        }

        System.out.println("");

        ClientCell[][] map=ProxyModel.instance().getMap();
        int i,j,k,m,w,q;
        int black=1;
        //bordi
        System.out.print(RED_BACKGROUND + "  " + RESET);
        for(i=0;i<=4;i++){
            for(m=0;m<=2;m++){
                if(black==1) {
                    if(m==1){
                        System.out.print(WHITE_BOLD+BLACK_BACKGROUND +" "+i + RESET);
                    }else
                        System.out.print(BLACK_BACKGROUND + "  " + RESET);

                }
                if(black==0){
                    if(m==1) {
                        System.out.print(BLACK_BOLD+WHITE_BACKGROUND +" "+ i + RESET);
                    }else
                        System.out.print(WHITE_BACKGROUND + "  " + RESET);

                }


            }
            if(black==0){
                black=1;
            }else
            {
                black=0;
            }
        }
        System.out.print(RED_BACKGROUND + "  " + RESET);

        System.out.println("");
        black=0;
        //ciclo y
        for(j=0;j<=4;j++){
                //ciclo degli strati cioe 3
                for(k=1;k<=3;k++)
                {
                    //laterali
                    if(black==1) {
                        if(k==2){
                            System.out.print(WHITE_BOLD+BLACK_BACKGROUND +j + " "+ RESET);
                        }else
                            System.out.print(BLACK_BACKGROUND + "  " + RESET);

                    }
                    if(black==0){
                        if(k==2) {
                            System.out.print(BLACK_BOLD+WHITE_BACKGROUND + j + " "+ RESET);
                        }else
                            System.out.print(WHITE_BACKGROUND + "  " + RESET);

                    }
                    //fine laterali

                    //ciclo x
                    for(i=0;i<=4;i++){
                    //per ogni cella fa 3 colonne
                    for(m=1;m<=3;m++){
                        if(map[i][j].getLevel()==0 && (k==1 || (k==2 && m==1)|| (k==2 && m==3)|| k==3 )){
                            if( map[i][j].getSelectable()==0) {
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(GREEN_BACKGROUND+GREEN_BOLD + ".." + RESET);
                                //se è selezionabile il giocatore
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(GREEN_BACKGROUND + BLACK_BOLD + "##" + WHITE_BOLD + RESET);
                            }
                            //se è selezionabile la cella
                            else if ( map[i][j].getSelectable()==1) {
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(GREEN_BACKGROUND + "§§" + RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(GREEN_BACKGROUND +BLACK_BOLD+ "§§" +WHITE_BOLD+ RESET);
                            }

                        } else if(map[i][j].getLevel()==1 && (k==1 || (k==2 && m==1)|| (k==2 && m==3)|| k==3 )){
                            if( map[i][j].getSelectable()==0) {
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(YELLOW_BACKGROUND +YELLOW_BOLD+ "°°" + RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(YELLOW_BACKGROUND + BLACK_BOLD + "##" + WHITE_BOLD + RESET);
                            }
                            else if ( map[i][j].getSelectable()==1){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(YELLOW_BACKGROUND + "§§" + RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(YELLOW_BACKGROUND +BLACK_BOLD+ "§§" +WHITE_BOLD+ RESET);
                            }
                        }else if(map[i][j].getLevel()==2 && (k==1 || (k==2 && m==1)|| (k==2 && m==3)|| k==3)){
                            if( map[i][j].getSelectable()==0){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(PURPLE_BACKGROUND+PURPLE_BOLD+"++"+RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(PURPLE_BACKGROUND + BLACK_BOLD + "##" + WHITE_BOLD + RESET);
                            }
                            else if ( map[i][j].getSelectable()==1){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(PURPLE_BACKGROUND + "§§" + RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(PURPLE_BACKGROUND +BLACK_BOLD+ "§§" +WHITE_BOLD+ RESET);
                            }
                        }else if(map[i][j].getLevel()==3 && (k==1 || (k==2 && m==1)|| (k==2 && m==3)|| k==3)){
                            if( map[i][j].getSelectable()==0){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(RED_BACKGROUND+RED_BOLD+"--"+RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(RED_BACKGROUND + BLACK_BOLD + "##" + WHITE_BOLD + RESET);
                            }
                            else if ( map[i][j].getSelectable()==1){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(RED_BACKGROUND + "§§" + RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(RED_BACKGROUND +BLACK_BOLD+ "§§" +WHITE_BOLD+ RESET);
                            }
                        }else if(map[i][j].getLevel()==4 && (k==1 || (k==2 && m==1)|| (k==2 && m==3)|| k==3)){
                            if( map[i][j].getSelectable()==0){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(BLUE_BACKGROUND+BLUE_BOLD+"##"+RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(BLUE_BACKGROUND + BLACK_BOLD + "##"  + RESET);

                            }
                            else if ( map[i][j].getSelectable()==1){
                                if (map[i][j].getWorker() == null || (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 0))
                                    System.out.print(BLUE_BACKGROUND+ "§§" + RESET);
                                else if (map[i][j].getWorker() != null && map[i][j].getWorker().getIsSelected() == 1)
                                    System.out.print(BLUE_BACKGROUND +BLACK_BOLD+ "§§" +WHITE_BOLD+ RESET);
                            }
                        }
                        if(map[i][j].getWorker()!=null && m==2 && k==2){
                            if(map[i][j].getWorker().getOwner().equals(player1)){
                                if(map[i][j].getworkerSelectable()!=1)
                                    System.out.print(map[i][j].getWorker().getColor()+"@@"+RESET);
                                else
                                    System.out.print(map[i][j].getWorker().getColor()+BLACK_BACKGROUND+"@@"+RESET);
                            }
                            else if(map[i][j].getWorker().getOwner().equals(player2)){
                                if(map[i][j].getworkerSelectable()!=1)
                                    System.out.print(map[i][j].getWorker().getColor()+"@@"+RESET);
                                else
                                    System.out.print(map[i][j].getWorker().getColor()+BLACK_BACKGROUND+"@@"+RESET);
                            }
                            else if(map[i][j].getWorker().getOwner().equals(player3)){
                                if(map[i][j].getworkerSelectable()!=1)
                                    System.out.print(map[i][j].getWorker().getColor()+"@@"+RESET);
                                else
                                    System.out.print(map[i][j].getWorker().getColor()+BLACK_BACKGROUND+"@@"+RESET);

                            }
                        }else if(map[i][j].getWorker()==null && m==2 && k==2) {
                            System.out.print("  ");
                        }



                    }


                }
                    //inizio bordi
                    if(black==1) {
                        if(k==2){
                            System.out.print(WHITE_BOLD+BLACK_BACKGROUND + " "+j + RESET);
                        }else
                            System.out.print(BLACK_BACKGROUND + "  " + RESET);

                    }
                    if(black==0){
                        if(k==2) {
                            System.out.print(BLACK_BOLD+WHITE_BACKGROUND +" "+ j + RESET);
                        }else
                            System.out.print(WHITE_BACKGROUND + "  " + RESET);

                    }
                    //fine bordi

                    System.out.println("");


            }
            if(black==0){
                black=1;
            }else
            {
                black=0;
            }
            //System.out.println("");
        }
        //bordi alternati nero/bianco
        System.out.print(RED_BACKGROUND + "  " + RESET);
        black=1;
        for(i=0;i<=4;i++){
            for(m=0;m<=2;m++){
                if(black==1) {
                    if(m==1){
                        System.out.print(WHITE_BOLD+BLACK_BACKGROUND +" "+i + RESET);
                    }else
                        System.out.print(BLACK_BACKGROUND + "  " + RESET);

                }
                if(black==0){
                    if(m==1) {
                        System.out.print(BLACK_BOLD+WHITE_BACKGROUND +" "+ i + RESET);
                    }else
                        System.out.print(WHITE_BACKGROUND + "  " + RESET);

                }


            }
            if(black==0){
                black=1;
            }else
            {
                black=0;
            }
        }
        System.out.print(RED_BACKGROUND + "  " + RESET);

        System.out.println("");
        System.out.println("");

    };
    public void setIsSelected(WorkerClient selectedWorker){
        selectedWorker.setIsSelected(1);
    }

    //mette 0 nella mappa
    public void setSelectableCell( List<Coords> selectableCoords,int value){
        ClientCell[][] map=ProxyModel.instance().getMap();

        int l,i;
        l=selectableCoords.size();
        if(value==1){
            for(i=0;i<l;i++){
                map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(1);
            }
        }else if(value==2){
            for(i=0;i<l;i++){
                map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setworkerSelectable(1);
            }
        }else if(value==0){
            for(i=0;i<l;i++){
                /* System.out.println("tolto"); */
                map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(0);
            }
        }

    }; //colora le celle che potrebbero essere selezionate

    public void setMoveWorker(WorkerClient selectedWorker,Coords moveCell){
        ClientCell[][] map=ProxyModel.instance().getMap();
        if(map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].getUnderWorker() != null)
            selectedWorker = map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].getUnderWorker();
            //cancello worker dalla posizione precedente
        else map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].setWorker(null);
        //lo metto nella cella+
        if(map[moveCell.getX()][moveCell.getY()].getWorker() != null) {
            map[moveCell.getX()][moveCell.getY()].setUnderWorker(selectedWorker);
        } else {
            map[moveCell.getX()][moveCell.getY()].setWorker(selectedWorker);
        }

        selectedWorker.setPosition(moveCell);
    };
    public void setBuild(Coords buildCell,int levelToBuild){
        ClientCell[][] map=ProxyModel.instance().getMap();
        map[buildCell.getX()][buildCell.getY()].setLevel(levelToBuild);
    };

    public void drawWinGame(){
        //showMessageDialog(null, "Hai vinto tutti i soldi di marco anese!!");
        System.out.println("Hai vinto !!");
    };
    public void drawLooseGame(){
        //showMessageDialog(null, "Hai perso! Hai contribuito a rendere i tuoi compagni meno felici");
        System.out.println("Hai perso!");

    };
    public void firstPlayerLogin(){};
    public void otherPlayersJoin(){};
    public void createPlayer(String namePlayer){
        Player player=new Player(namePlayer);
        ProxyModel.instance().addPlayer(player);
    };
    public void createWorker1(Player player,Coords startCoords, int index){
        ClientCell[][] map=ProxyModel.instance().getMap();
        WorkerClient worker=new WorkerClient(player,startCoords,index);
        player.setWorker1(worker);
        map[startCoords.getX()][startCoords.getY()].setWorker(worker);
    };
    public void createWorker2(Player player,Coords startCoords, int index){
        ClientCell[][] map=ProxyModel.instance().getMap();
        WorkerClient worker=new WorkerClient(player,startCoords,index);
        player.setWorker2(worker);
        map[startCoords.getX()][startCoords.getY()].setWorker(worker);

    };
}
