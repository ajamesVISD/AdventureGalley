package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

/**
 * Enroll this command with an Item subclass so that it handles the word
 * "examine." Just returns the description.
 */
public class Examine extends Executable {

    public Examine() {
        super();
        addKeyword("examine");
        addKeyword("look at");
    }

    public String execute(Actor a, Player player) {
        return a.getDescription();
    }
}
