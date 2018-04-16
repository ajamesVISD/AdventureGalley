package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Executable;
import org.vashonsd.AdventureGalley.Interactions.Item;

/**
 * Enroll this command with an Item subclass so that it handles the word
 * "examine." Just returns the description.
 */
public class Examine implements Executable {

    public String execute(Item i) {
        return i.getDescription();
    }
}
