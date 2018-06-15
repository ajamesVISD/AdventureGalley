package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Reverse;

public class Hammer extends Item {

    public Hammer() {
        super("hammer", "a rusty old hammer", false);
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
