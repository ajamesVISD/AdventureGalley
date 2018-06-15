package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Actor;

public abstract class Item extends Actor {

    private boolean edible;

    public Item(String name, String description, boolean edible) {
        super(name, description);
        this.edible = edible;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }
}
