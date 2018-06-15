package org.vashonsd.AdventureGalley;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    World world;

    @Before
    public void setUp() throws Exception {
        world = World.fromBuilder().fromFile("home").build();
    }

    @Test
    public void testWorldHasName() {
        System.out.println(world.getName());
        Assert.assertNotNull(world.getName());
    }

    @Test
    public void testBuildWorld() {
        Assert.assertNotNull(world);
    }
}