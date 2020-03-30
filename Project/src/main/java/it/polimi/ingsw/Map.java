package it.polimi.ingsw;

public class Map {
    private Cell[][] map;

    public Map(){}

    public Cell getCell(int x , int y){
        return map[x][y];
    }
}
