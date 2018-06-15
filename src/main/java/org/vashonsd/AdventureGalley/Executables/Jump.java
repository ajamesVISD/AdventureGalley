package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Jump extends Executable {

    public Jump() {
        super();
        addKeyword("leap");
        addKeyword("jump");
    }

    public String execute(Actor a, Player player) {
        player.broadcast(player.getName() + " leaps into the air!");
        return "You leap into the air, looking foolish.";
    }
}
