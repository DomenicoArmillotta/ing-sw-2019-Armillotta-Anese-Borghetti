package it.polimi.ingsw.client.proxymodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.ClientEvent;

import java.io.PrintWriter;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * it contains the current situation of the game which is inside the game server, removing the logic
 */
public class ProxyModel {

    private static ProxyModel instance;
    private List<Player> players = new ArrayList<>();
    private Turn turn;
    String thisClientNickname;
    String partyOwner;
    private ClientCell[][] map;
    private Drawer drawerStrategy;
    Phase phase;
    private PrintWriter printWriter;
    public Socket thisScoket;

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public List<Player> getPlayers() {
        return players;
    }

    /**
     * add a player to the list of players string, used by the cli
     * @param playerName the player name
     */
    public void addPlayer(String playerName){
        Player playerToAdd = new Player(playerName);
        this.players.add(playerToAdd);
    }

    /* public void removePlayer(String playerName) {
        boolean removed = false;
        for(int i = players.size()-1; !removed && i >= 0; i--) {
            if(players.get(i).getName().equals(playerName)) {
                this.players.remove(players.get(i));
                removed = true;
            }
        }
    } */

    public static ProxyModel instance() {
        if (instance == null) {
            instance = new ProxyModel();
            instance.createMap();
        }
        return instance;
    }

    private ProxyModel() {
        this.thisClientNickname = "";
        this.partyOwner = "";
    }

    public String getThisClientNickname() {
        return thisClientNickname;
    }
    public void setThisClientNickname(String thisClientNickname) {
        this.thisClientNickname = thisClientNickname;
    }

    public String getPartyOwner() {
        return partyOwner;
    }
    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }

    public Drawer getDrawerStrategy() {
        return drawerStrategy;
    }
    public void setDrawerStrategy(Drawer drawerStrategy) {
        this.drawerStrategy = drawerStrategy;
    }

    public Turn getTurn(){
        return this.turn;
    }

    /**
     * create a turn for the game
     */
    public void createTurn(){
        this.turn = new Turn();
    }

    public ClientCell[][] getMap() {
        return map;
    }

    /**
     * create a map for the cli,the map is made up of a cell vector
     * the cell contains all the useful information to draw everything of the cli,
     * then to do the operations I will change the state of the cells and then I will draw it in the cliDrawer
     */
    public void createMap(){
        ClientCell[][] map = new ClientCell[5][5];
        int i,j;
        for(i=0;i<5;i++){
            for(j=0;j<5;j++) {
                map[i][j]=new ClientCell();
                map[i][j].setLevel(0);
            }
        }
        this.map = map;
    }

    /**
     * create worker 1 of the player
     * @param player player of the worker
     * @param startCoords initial coordinates of the first worker
     * @param index the index
     */
    public void createWorker1(Player player,Coords startCoords, int index){
        ClientCell[][] map = getMap();
        WorkerClient worker=new WorkerClient(player,startCoords,index);
        player.setWorker1(worker);
        map[startCoords.getX()][startCoords.getY()].setWorker(worker);
    }
    /**
     * create worker 2 of the player
     * @param player player of the worker
     * @param startCoords initial coordinates of the second worker
     * @param index the index
     */
    public void createWorker2(Player player,Coords startCoords, int index){
        ClientCell[][] map = getMap();
        WorkerClient worker=new WorkerClient(player,startCoords,index);
        player.setWorker2(worker);
        map[startCoords.getX()][startCoords.getY()].setWorker(worker);
    }

    /**
     * add worker selectable cells to the list while doing build, move and select operations
     * @param selectableCoords list of coordinates that identify the selectable cells
     */
    public void addSelectableCells( List<Coords> selectableCoords){
        ClientCell[][] map = getMap();

        int length, i;
        length=selectableCoords.size();
        for(i=0; i<length; i++){
            map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(1);
        }

    }

    /**
     * reset of list of selectable cells
     */
    public void clearSelectableCells() {
        ClientCell[][] map = getMap();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                map[i][j].setSelectable(0);
    }

    /**
     * remove worker selectable cells to the list
     * @param selectableCoords list of coordinates that identify the selectable cells
     */
    public void removeSelectableCells( List<Coords> selectableCoords){
        ClientCell[][] map = getMap();

        int length, i;
        length=selectableCoords.size();
        for(i=0; i<length; i++){
            map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(0);
        }

    }

    /**
     * makes the movement of the worker,set the worker in the cell where he moves, and delete it from the previous one
     * @param selectedWorker the selected worker
     * @param moveCell the movement cell
     */
    public void setMoveWorker(WorkerClient selectedWorker,Coords moveCell){
        ClientCell[][] map=getMap();
        if(map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].getUnderWorker() != null) {
            selectedWorker = map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].getWorker();
            map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].setWorker(map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].getUnderWorker());
        }
        else {
            map[selectedWorker.getPosition().getX()][selectedWorker.getPosition().getY()].setWorker(null);
        }
        if(map[moveCell.getX()][moveCell.getY()].getWorker() != null) {
            map[moveCell.getX()][moveCell.getY()].setUnderWorker(selectedWorker);
        } else {
            map[moveCell.getX()][moveCell.getY()].setWorker(selectedWorker);
        }

        selectedWorker.setPosition(moveCell);
    }

    /**
     * I set the level of the cell on which I want to build the level passed as a parameter
     * @param buildCell the build cell
     * @param levelToBuild level to build
     */
    public void setBuild(Coords buildCell,int levelToBuild){
        ClientCell[][] map=getMap();
        map[buildCell.getX()][buildCell.getY()].setLevel(levelToBuild);
    }

    public PrintWriter getPrintWrite() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    /*synchronized public void sendAutonomousEvents(ClientEvent clientEvent) throws JsonProcessingException {
        XmlMapper xmlMapper = (new XmlMapper());
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        String toSend = xmlMapper.writeValueAsString(clientEvent);
        toSend = toSend + "\n";
        this.printWriter.print(toSend);
        this.printWriter.flush();
    }*/
    /*public void deleteWorkersFromMap(String loser){
        for (Player player:players){
            if(player.getName().equals(loser)){
                player.setWorker1(null);
                player.setWorker2(null);
            }
        }
    }*/
}
