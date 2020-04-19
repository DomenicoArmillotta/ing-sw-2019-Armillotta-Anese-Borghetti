package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.List;

public class GodCard {
    private String godName;
    private String description;
    private List<Power> powerList=new ArrayList<>();
    public GodCard(String godName,String description){
        this.godName=godName;
        this.description=description;
    }

    public String getGodName() {
        return godName;
    }
    public String getDescription() {
        return description;
    }



