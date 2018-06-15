package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Take;

public class Mug extends Item {
    public Mug(){
        super("Mug","An artisan mug",false);
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
        addExecutable(new Take());
    }

    @Override
    public void setType(String str) {

    }
}
