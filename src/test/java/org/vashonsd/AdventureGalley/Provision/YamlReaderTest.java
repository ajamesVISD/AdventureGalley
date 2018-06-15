package org.vashonsd.AdventureGalley.Provision;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class YamlReaderTest {

//    Room testRoom;
    private WorldSchema worldSchema;

    @Before
    public void setUp() throws Exception {
//        testRoom = new YamlReader().readRoom();
        worldSchema = new YamlReader("defaultWorld").readYaml();
    }

//    @Test
//    public void testReadRoom() {
//        System.out.println(testRoom.getName());
//        System.out.println(testRoom.getDescription());
//        System.out.println(testRoom.getSplashes());
//        Assert.assertTrue(testRoom.hasItem("apple"));
//    }


    @Test
    public void readYaml() {
        System.out.println(ReflectionToStringBuilder.toString(worldSchema));
    }
}