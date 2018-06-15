package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Yell extends Executable {
    public Yell() {
        super();
        addKeyword("yell");
    }

    @Override
    public String execute(Actor a, Player player) {
        player.broadcast("AUGGHHH, " + player.getName() + " yells.");
        return "Your voice echoes around the room.";
    }
}
