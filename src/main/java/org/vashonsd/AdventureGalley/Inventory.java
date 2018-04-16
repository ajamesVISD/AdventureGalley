package org.vashonsd.AdventureGalley;
import org.vashonsd.AdventureGalley.Interactions.Item;

import java.util.HashMap;


public class Inventory {

    HashMap<String, Item> inventory;

    public Inventory() {
        inventory = new HashMap<String, Item>();
    }

    /*
    * Puts an Item into the inventory.
    * */
    public void addItem(Item i) {
        inventory.put(i.getName(), i);
    }

    /*
    * Removes Item from the inventory.
    * @param    i The item to be removed.
    * */
    public void removeItem (Item i) {
        inventory.remove(i.getName());
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
    public Item getItem(String name) {
        return inventory.get(name);
    }


    /*
    * Returns a minimally formatted version of the keys in the inventory.
    * */
    public String toString() {
        return inventory.keySet().toString();
    }
}
