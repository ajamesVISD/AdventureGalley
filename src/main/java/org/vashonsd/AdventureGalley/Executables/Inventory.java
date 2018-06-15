package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Inventory extends Executable {

    public Inventory() {
        addKeyword("inventory");
    }

    @Override
    public String execute(Actor a, Player player) {
        return player.getInventory().toString();
    }
}
