package org.vashonsd.AdventureGalley.Interactions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.vashonsd.AdventureGalley.Items.Apple;
import org.vashonsd.AdventureGalley.Items.Pencil;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class InventoryTest {
    Inventory inventory;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();
        inventory.addActor(new Apple());
        inventory.addActor(new Pencil(), "Here is a pencil", true, true);
        inventory.addActor(new Player("testName", "a player to test"), "testing",false, false);
    }

    @Test
    public void visibleInInventory() {
        Map<String, Placement> visibles = inventory.visibleInInventory();
        System.out.println(visibles);
        Assert.assertEquals(visibles.keySet().size(), 2);
    }

    @Test
    public void receiversInInventory() {
        Map<String, Placement> receivers = inventory.receiversInInventory();
        System.out.println(receivers);
        Assert.assertEquals(receivers.keySet().size(), 2);
    }

    @Test
    public void playersInInventory() {
        Map<String, Player> players = inventory.playersInInventory();
        System.out.println(players);
        Assert.assertEquals(players.keySet().size(), 1);
    }

    @Test
    public void testGetSplashes() {
        List<String> splashes = inventory.getSplashes();
        System.out.println(splashes);
        Assert.assertEquals(splashes.size(), 1);
    }
}