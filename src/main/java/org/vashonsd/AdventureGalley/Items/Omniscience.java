package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.*;

public class Omniscience extends Item {

    public Omniscience() {
        super("omniscient", "", false);
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Jump());
        addExecutable(new Look());
        addExecutable(new Yell());
        addExecutable(new Inventory());
        addExecutable(new Vocabulary());
    }

    @Override
    public void setType(String str) {

    }
}
