package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Reverse;

/**
 * Created by andy on 3/5/18.
 */
public class Banana extends Item {

    public Banana() {
        super("banana", "a delicious yellow banana.", true);
        addExecutable(new Examine());
        addExecutable(new Reverse());
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
    }

    @Override
    public void setType(String str) {

    }
}
