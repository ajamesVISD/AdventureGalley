package org.vashonsd.AdventureGalley.Executables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Minigames.MinigameAdapter;

import java.util.concurrent.LinkedBlockingDeque;

public class PlayTest {

    Play play;
    MinigameAdapter minigameAdapter;
    Player player;

    @Before
    public void setUp() throws Exception {
        play = new Play();
        minigameAdapter = new MinigameAdapter();
        minigameAdapter.setType("20q");
        player = new Player("test", "test description");
        player.setUuid("james.elliott");
        player.setOutboundMessages(new LinkedBlockingDeque<>());
    }

    @Test
    public void testExecute() {
        player.dispatch("play 20q");
        Assert.assertTrue(minigameAdapter.getConversationStatus(player));
        Assert.assertNotNull(player.getTarget());
    }
}