package org.vashonsd.AdventureGalley.Player;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Inventory;

public class Player extends Actor {
    private Inventory inventory;
    private String name;
    private PlayerState playerState;

    public Player(String name) {
        super(name, "the current player");
        playerState = new PlayerState(100, true);
    }
}
