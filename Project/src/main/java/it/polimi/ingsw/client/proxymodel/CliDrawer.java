package it.polimi.ingsw.client.proxymodel;

import java.util.List;


public class CliDrawer extends Drawer{

    public static final String RESET = "\033[0m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String BLACK_BACKGROUND = "\033[40m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String PURPLE_BACKGROUND = "\033[45m";
    public static final String CYAN_BACKGROUND = "\033[46m";
    public static final String WHITE_BACKGROUND = "\033[47m";


    public void promptSelectionText() {
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getNextPlayer().getName() + "\u001B[0m" + " should select a worker typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed by its "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    };
    public void promptMovementText() {
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should move the selected worker typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    };
    public void promptBuildText() {
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should build a block typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed the desired "+"\u001B[33m" + "2 coordinates" + "\u001B[0m"+".");
    };

    public void promptPlaceWorkersTest() {
        System.out.println("\u001B[36m" + ProxyModel.instance().getTurn().getCurrentPlayer().getName() + "\u001B[0m" + " should place his 2 workers typing " + "\u001B[33m" + "coords" + "\u001B[0m" + " followed by the desired "+"\u001B[33m" + "4 coordinates" + "\u001B[0m"+".");
    };

    /**
     *
     * This function converts the values ​​of the virtual matrix map to those to be displayed in the prompt.
     * Create the edges of the map and draw each cell of the map according to a structure consisting of 9 spaces
     *
     **/
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
    public void drawWinGame(){
        System.out.println("Hai vinto !!");
    };
    public void drawLooseGame(String loser){
        System.out.println("Ha perso "+loser);

    };

    public void login(){
        System.out.println(PURPLE_BOLD+"SANTORINI BOARD GAME CLI SIMULATION"+RESET+" (AM46)");
        System.out.println("Type "+YELLOW_BOLD+"login"+RESET+" followed by your nickname to create a room or join an existing one.");

    };
    public void title(){};
}
