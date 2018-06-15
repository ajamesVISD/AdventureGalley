package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

public class Vocabulary extends Executable {

    public Vocabulary() {
        addKeyword("vocabulary");
    }

    @Override
    public String execute(Actor a, Player player) {
        return Executable.getLexicon().toString();
    }
}
