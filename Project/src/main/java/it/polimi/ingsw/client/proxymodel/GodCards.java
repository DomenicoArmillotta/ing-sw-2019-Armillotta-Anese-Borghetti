package it.polimi.ingsw.client.proxymodel;

/**
 * used to store name and description to be shown to the player
 */
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
