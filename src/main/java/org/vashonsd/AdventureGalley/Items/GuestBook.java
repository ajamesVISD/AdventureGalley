package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;

public class GuestBook extends Item {
    public GuestBook() {
        super("Guest Book",
                "A string connects a pen to this book, which is filled with other people's scribbles",
                false);
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
    }

    @Override
    public void setType(String str) {

    }
}
