package org.vashonsd.AdventureGalley.Interactions;

import java.util.HashMap;
import java.util.Set;

public class Room extends Actor {

    HashMap<String, Room> connectedRooms = new HashMap<String, Room>();

    public Room(String name, String description) {
        super(name, description);
    }

    public boolean hasRoom(String name) {
        return connectedRooms.containsKey(name);
    }

    public Room getRoom(String name) {
        return connectedRooms.get(name);
    }

    //This method gets a Room, then uses its name to add it to the list of connected rooms.
    public void addRoom(Room room) {
        connectedRooms.put(room.getName(),room);
    }

    public Set<String> getConnectedRooms(){
        return connectedRooms.keySet();
    }
}
