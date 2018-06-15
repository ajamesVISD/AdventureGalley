package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Look extends Executable {


    public Look() {
        super();
        addKeyword("look");
    }

    @Override
    public String execute(Actor a, Player player) {
        return player.getCurrentRoom().getDescription();
    }
}
