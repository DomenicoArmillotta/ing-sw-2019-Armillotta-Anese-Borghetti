package it.polimi.ingsw.client.proxymodel;

public class GodCards {
    private String name;
    private String description;

    public GodCards(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
