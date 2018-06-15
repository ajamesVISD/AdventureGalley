package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;

public class Baseball extends Item {

    Baseball() {
        super("baseball", "It is a pearly white baseball.", false);
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
    }

    @Override
    public void setType(String str) {

    }
}
