package org.vashonsd.AdventureGalley.Executables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class ExecutableTest {

    Executable executable;
    Executable exec2;

    @Before
    public void setUp() throws Exception {
        executable = new Examine();
        exec2 = new Reverse();
    }

    @Test
    public void getLexicon() {
        Assert.assertEquals(Executable.getLexicon().size(), 3);
    }

    @Test
    public void inLexicon() {
        Assert.assertTrue(Executable.inLexicon("examine"));
        Assert.assertFalse(Executable.inLexicon("ghghghgh"));
    }

    @Test
    public void addKeyword() {
    }

    @Test
    public void getKeywords() {
    }
}