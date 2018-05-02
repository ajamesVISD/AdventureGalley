package org.vashonsd.AdventureGalley.Interactions;
import org.vashonsd.AdventureGalley.Interactions.Item;

import java.util.HashMap;


public class Inventory {

    HashMap<String, Actor> inventory;

    public Inventory() {
        inventory = new HashMap<String, Actor>();
    }

    /*
    * Puts an Item into the inventory.
    * */
    public void addItem(Actor a) {
        inventory.put(a.getName(), a);
    }

    /*
    * Removes Item from the inventory.
    * @param    i The item to be removed.
    * */
    public void removeItem (Actor a) {
        inventory.remove(a.getName());
    }

    /*
    * Returns boolean for if an item answering to the given name exists in the Inventory.
    * */
    public boolean hasItem(String name) {
        return inventory.containsKey(name);
    }

    /*
    * Do not call this method unless you are sure the item is in the inventory.
    * */
    public Actor getActor(String name) {
        return inventory.get(name);
    }


    /*
    * Returns a minimally formatted version of the keys in the inventory.
    * */
    public String toString() {
        return inventory.keySet().toString();
    }
}
