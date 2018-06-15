package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Go;
import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Room;

public class Traversal extends Actor {

    private Room connectedRoom;

    public Traversal(String name, String description, Room connectedRoom) {
        super(name, description);
        this.connectedRoom = connectedRoom;
    }

    public Room getConnectedRoom() {
        return connectedRoom;
    }

    public void setConnectedRoom(Room connectedRoom) {
        this.connectedRoom = connectedRoom;
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Go());
    }

    @Override
    public void setType(String str) {

    }
}
