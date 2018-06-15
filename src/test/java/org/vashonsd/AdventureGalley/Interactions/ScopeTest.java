package org.vashonsd.AdventureGalley.Interactions;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.AdventureGalley.Items.Apple;
import org.vashonsd.AdventureGalley.Items.Book;
import org.vashonsd.AdventureGalley.Items.Pencil;
import org.vashonsd.AdventureGalley.Room;

import static org.junit.Assert.*;

public class ScopeTest {

    Scope scope;

    @Before
    public void setUp() throws Exception {
        scope = new Scope();
        Player player = new Player("dummy", "just for a test");
        Room startingRoom = new Room("startHere", "room");
        startingRoom.addItem(new Apple());
        startingRoom.addItem(new Pencil());
        player.addItem(new Book());
        player.setCurrentRoom(startingRoom);
        scope.scopeFor(player);
    }

    @Test
    public void scopeFor() {
        System.out.println(scope);
    }
}