package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Interfaces.Readable;

public class Read extends Executable {
    public Read() {
        addKeyword("read");
    }

    @Override
    public String execute(Actor a, Player player) {
        Readable readable = (Readable)a;
        return readable.read();
    }
}
