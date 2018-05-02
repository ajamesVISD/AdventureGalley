package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Executable;
import org.vashonsd.AdventureGalley.Interactions.Item;
import org.vashonsd.AdventureGalley.Interactions.Response;

/**
 * Enroll this command with an Item subclass so that it handles the word
 * "examine." Just returns the description.
 */
public class Examine implements Executable {

    public Response execute(Actor a) {
        return new Response(a.getDescription(), false);
    }
}
