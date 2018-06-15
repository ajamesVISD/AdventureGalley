package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Drop extends Executable {

    public Drop() {
        addKeyword("drop");
    }

    @Override
    public String execute(Actor a, Player player) {
        player.getInventory().removeActor(a);
        player.broadcast(player.getName() + " has dropped the " + a.getName() + ".");
        player.getCurrentRoom().addItem(a, a.getSplash());
        a.removeExecutable(this);
        a.addExecutable(new Take());
        return a.getName() + ": dropped.";
    }
}
