package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Items.Traversal;
import org.vashonsd.AdventureGalley.Room;

public class Go extends Executable {

    public Go() {
        super();
        addKeyword("go");
        addKeyword("travel");
    }

    @Override
    public String execute(Actor a, Player player) {
        Traversal traversal = (Traversal)a;
        Room toRoom = traversal.getConnectedRoom();
        player.broadcast(player.getName() + " has left.");
        player.setCurrentRoom(toRoom);
        player.broadcast(player.getName() + " has entered.");
        return toRoom.getDescription();
    }
}
