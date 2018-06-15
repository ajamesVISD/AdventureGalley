package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Take extends Executable {

    public Take() {
        super();
        addKeyword("take");
    }

    @Override
    public String execute(Actor a, Player player) {
        player.getCurrentRoom().removeActor(a);
        player.addItem(a);
        player.broadcast(player.getName() + "has taken: " + a.getName());
        a.removeExecutable(this);
        a.addExecutable(new Drop());
        return a.getName() + ": taken.";
    }
}
