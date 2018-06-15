package org.vashonsd.AdventureGalley;
import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Inventory;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Items.Item;
import org.vashonsd.AdventureGalley.Items.Omniscience;
import org.vashonsd.AdventureGalley.Items.Traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Room extends Actor {

    public Room(String name, String description) {
        super(name, description);
        inventory.addActor(new Omniscience(), null, false,true);
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
    }

    public void broadcast(String str) {
        for(Player p : inventory.playersInInventory().values()) {
            p.publish(str);
        }
    }

    public void removeActor(Actor a) {
        inventory.removeActor(a);
    }

    @Override
    public void setType(String str) {

    }

    public void addConnectedRoom(Room r, String direction, String description) {
        inventory.addActor(new Traversal(direction, description, r));
    }

    public void addTraversal(Traversal traversal) {
        inventory.addActor(traversal);
    }

    @Override
    public String getDescription() {
        String result = this.description;
//        result += getInventory().toString();
        List<String> splashes = inventory.getSplashes();
        for(String splash : splashes) {
            result += "\n" + splash;
        }
        return result;
    }
}
