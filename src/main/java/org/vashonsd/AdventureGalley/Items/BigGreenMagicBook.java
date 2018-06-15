package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Jump;
import org.vashonsd.AdventureGalley.Executables.Look;
import org.vashonsd.AdventureGalley.Executables.Take;

public class BigGreenMagicBook extends Item {


    public BigGreenMagicBook(){
        super("Big Green Magic Book", "A super boring book written by Karl Marx and Friedrich Engels... but magical", false);
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
