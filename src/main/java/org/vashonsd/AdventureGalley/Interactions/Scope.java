package org.vashonsd.AdventureGalley.Interactions;

import org.vashonsd.AdventureGalley.Room;

import java.util.Map;

/**
 * A Scope keeps all Actors that are within a particular scope.
 */
public class Scope {

    /**
     * Think of this as the flattened version of all the many inventories we will be taking in.
     */
    private Inventory inventory;

    public Scope() {
        inventory = new Inventory();
    }

    /**
     * Hand it a Player, and it figures the scope for that Player.
     * @param p
     */
    public void scopeFor(Player p) {
        //First, enroll everything in the Player's inventory.
        addInventory(p.getInventory(), true, true);
        //Then enroll everything in the Room's inventory.
        Room currentRoom = p.getCurrentRoom();
        inventory.addActor(currentRoom, currentRoom.getDescription(), true, true );
        addInventory(currentRoom.getInventory(), true, true);
    }

    /**
     *
     * @param in
     * @param visible The default visibility for all objects in this inventory.
     * @param receiver The default receiver status for all objects in this inventory.
     */
    private void addInventory(Inventory in, boolean visible, boolean receiver) {
        for(Placement placement : in.receiversInInventory().values()) {
            inventory.addActor(placement.getActor(), placement.getSplash(), placement.isVisible(), placement.isReceiver());
            //The following is, let's face it, a hack. We just won't look into other Players' inventories.
            if(placement.isVisible() && placement.isReceiver() && placement.getActor().getClass() != Player.class) {
                addInventory(placement.getActor().getInventory(), true, true);
            }
        }
    }

    public boolean contains(String str) {
        return inventory.hasActor(str);
    }

    public Actor get(String str) {
        return inventory.getActor(str);
    }
}
