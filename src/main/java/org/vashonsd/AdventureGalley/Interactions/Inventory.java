package org.vashonsd.AdventureGalley.Interactions;
import org.vashonsd.AdventureGalley.Items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Inventory {

    Map<String, Placement> inventory;

    public Inventory() {
        inventory = new HashMap<String, Placement>();
    }

    public Map<String, Placement> visibleInInventory() {
        return filterBy(x -> x.getValue().isVisible());
    }

    public Map<String, Placement> receiversInInventory() {
        return filterBy(x -> x.getValue().isReceiver());
    }

    public Map<String, Player> playersInInventory() {
        return inventory.entrySet()
                .stream()
                .filter(x -> x.getValue().getActor().getClass() == Player.class)
                .collect(Collectors.toMap(x -> x.getKey(), x -> (Player)x.getValue().getActor()));
    }

    public Map<String, Placement> filterBy(Predicate<Map.Entry<String, Placement>> p) {
        return inventory.entrySet()
                .stream()
                .filter(e -> p.test(e))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }

    public List<String> getSplashes() {
        return inventory.values()
                .stream()
                .filter(e -> e.isVisible())
                .filter(e -> e.getSplash() != null)
                .map(Placement::getSplash)
                .collect(Collectors.toList());
    }

    /*
    * Puts an Item into the inventory.
    * */
    public void addActor(Actor a) {
        inventory.put(a.getName().toLowerCase(), new Placement(a));
    }

    public void addActor(Actor a, String splash, boolean visible, boolean receiver) {
        inventory.put(a.getName().toLowerCase(),
                new Placement(a, splash, visible, receiver));
    }

    public void addActor(Actor a, boolean visible, boolean receiver) {
        inventory.put(a.getName().toLowerCase(),
                new Placement(a, "", visible, receiver));
    }

    /*
    * Removes Item from the inventory.
    * @param    i The item to be removed.
    * */
    public void removeActor(Actor a) {
        inventory.remove(a.getName());
    }

    /*
    * Returns boolean for if an item answering to the given name exists in the Inventory.
    * */
    public boolean hasActor(String name) {
        return inventory.containsKey(name);
    }

    /*
    * Do not call this method unless you are sure the item is in the inventory.
    * */
    public Actor getActor(String name) {
        return inventory.get(name).getActor();
    }


    /*
    * Returns a minimally formatted version of the keys in the inventory.
    * */
    public String toString() {
        return inventory.keySet().toString();
    }
}
