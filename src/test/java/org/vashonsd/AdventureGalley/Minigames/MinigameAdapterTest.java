package org.vashonsd.AdventureGalley.Minigames;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.AdventureGalley.Interactions.Player;

import static org.junit.Assert.*;

public class MinigameAdapterTest {

    private MinigameAdapter minigameAdapter;
    private Player player;

    @Before
    public void setUp() throws Exception {
        minigameAdapter = new MinigameAdapter();
        minigameAdapter.setType("20q");
        player = new Player();
    }

    @Test
    public void setType() {

    }

    @Test
    public void enrollPlayer() {
        minigameAdapter.enrollPlayer(player);

    }

    @Test
    public void removePlayer() {
    }
}