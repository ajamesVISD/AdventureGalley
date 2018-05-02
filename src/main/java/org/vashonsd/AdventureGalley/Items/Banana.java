package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Interactions.Item;
import org.vashonsd.AdventureGalley.Executables.Reverse;

/**
 * Created by andy on 3/5/18.
 */
public class Banana extends Item {

    public Banana() {
        super("banana", "a delicious yellow banana.");
        addExecutable("examine", new Examine());
        addExecutable("reverse", new Reverse());
    }
}
