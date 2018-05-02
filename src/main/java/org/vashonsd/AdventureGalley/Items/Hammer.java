package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Interactions.Item;
import org.vashonsd.AdventureGalley.Executables.Reverse;

public class Hammer extends Item {

    public Hammer() {
        super("hammer", "a rusty old hammer");
        addExecutable("examine", new Examine());
        addExecutable("reverse", new Reverse());
    }

}
