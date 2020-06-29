package it.polimi.ingsw.client.proxymodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import it.polimi.ingsw.client.ClientEvent;

import java.io.PrintWriter;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProxyModel {

    private static ProxyModel instance;
    private List<Player> players = new ArrayList<>();
    private Turn turn;
    String thisClientNickname;
    String partyOwner;
    private ClientCell[][] map;
    private Drawer drawerStrategy;
    int phase;
    private PrintWriter printWriter;
    public Socket thisScoket;

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(String playerName){
        Player playerToAdd = new Player(playerName);
        this.players.add(playerToAdd);
    }

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

    public void createTurn(){
        this.turn = new Turn();
    }

    public ClientCell[][] getMap() {
        return map;
    }
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

    public void createWorker1(Player player,Coords startCoords, int index){
        ClientCell[][] map = getMap();
        WorkerClient worker=new WorkerClient(player,startCoords,index);
        player.setWorker1(worker);
        map[startCoords.getX()][startCoords.getY()].setWorker(worker);
    }

    public void createWorker2(Player player,Coords startCoords, int index){
        ClientCell[][] map = getMap();
        WorkerClient worker=new WorkerClient(player,startCoords,index);
        player.setWorker2(worker);
        map[startCoords.getX()][startCoords.getY()].setWorker(worker);
    }

    public void addSelectableCells( List<Coords> selectableCoords){
        ClientCell[][] map = getMap();

        int length, i;
        length=selectableCoords.size();
        for(i=0; i<length; i++){
            map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(1);
        }

    }

    public void clearSelectableCells() {
        ClientCell[][] map = getMap();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                map[i][j].setSelectable(0);
    }

    public void removeSelectableCells( List<Coords> selectableCoords){
        ClientCell[][] map = getMap();

        int length, i;
        length=selectableCoords.size();
        for(i=0; i<length; i++){
            map[selectableCoords.get(i).getX()][selectableCoords.get(i).getY()].setSelectable(0);
        }

    }

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
}
