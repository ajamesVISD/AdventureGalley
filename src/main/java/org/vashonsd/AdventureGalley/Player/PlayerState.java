package org.vashonsd.AdventureGalley.Player;

import org.vashonsd.AdventureGalley.Interactions.Room;

/**
 * Created by andy on 5/2/18.
 */
public class PlayerState {
    int health;
    boolean isAlive;
    Room currentRoom;

    public PlayerState(int health, boolean isAlive) {
        this.health = health;
        this.isAlive = isAlive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
