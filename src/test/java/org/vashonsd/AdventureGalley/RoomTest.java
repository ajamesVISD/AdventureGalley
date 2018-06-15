package org.vashonsd.AdventureGalley;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.vashonsd.AdventureGalley.Items.Apple;

import static org.junit.Assert.*;

public class RoomTest {

    Room room;

    @Before
    public void setUp() throws Exception {
        room = new Room("test", "a test description");
    }

    @Test
    public void listItemsInRoom() {
    }

    @Test
    public void addItem() {
        room.addItem(new Apple());
        Assert.assertEquals(room.getInventory().visibleInInventory().size(), 1);
    }

    @Test
    public void hasItem() {
    }
}