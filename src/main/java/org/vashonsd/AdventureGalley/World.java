package org.vashonsd.AdventureGalley;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Items.*;
import org.vashonsd.AdventureGalley.Provision.WorldSchema;
import org.vashonsd.AdventureGalley.Provision.YamlReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class World {
    String name;
    Room startingRoom;
    String intro;

    /*
    Creates a World with the given name.
    ex: "World cw = new World("CrazyWorld");
     */
    public World(String name){
        this.name = name;
    }

    public static World getWorld(String whichWorld) {
        if(whichWorld == "Crazy") {
            return originalWorld();
        } else {
            return null;
        }
    }

    public String getIntro() {
        return intro;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    public Room setStartingRoom(Room r) {
        startingRoom = r;
        return r;
    }

    public static World originalWorld(){
        World thisWorld = new World("CrazyWorld");
//
//        Room home = new Room("home", "You are in a simple gray room.");
//        Room cave = new Room("cave", "This room glitters with jewels.");
//        Room arcade = new Room("arcade","This  room is full of skee ball courts");
//        Room garage = new Room("garage","this room is full of cardboard boxes");
//
//        home.addItem(new Book("book","it is a book","these are some words"));
//        home.addItem(new Apple());
//        home.addItem(new Banana());
//        home.addItem(new Hammer());
//        garage.addItem(new Mug());
//        arcade.addRoom(home);
//        arcade.addRoom(cave);
//
//        home.addRoom(garage);
//        home.addRoom(cave);
//        home.addRoom(arcade);
//
////        home.itemsInRoom.addItem(new Banana());
////        home.itemsInRoom.addItem(new Item("note", "Welcome to our game.", false));
////        garage.itemsInRoom.addItem(new Item("Hammer", "A very heavy duty hammer.", false));
////        garage.itemsInRoom.addItem(new Item("Drill","Does not come with a drill bit.", false));
////        arcade.itemsInRoom.addItem(new Item("controller", "This is a video game controller or an unknown game system.", false));
////        arcade.itemsInRoom.addItem(new Item("jacket", " 80's style jacket with teal and purple detailing.", false));
////        cave.itemsInRoom.addItem(new Item("charcoal stick", " A stick of charcoal that looks like it has been on the walls", false));
////        cave.itemsInRoom.addItem(new Item("arrowhead", "An arrowhead make out of what seems to be some sort of bone", false));
//
//        garage.addRoom(home);
//        garage.addRoom(arcade);
//
//        cave.addRoom(garage);
//        cave.addRoom(home);
//        thisWorld.setStartingRoom(home);
        return thisWorld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final Builder fromBuilder() {
        return new Builder();
    }

    public static final class Builder {
        String name;
        Room startingRoom;
        String intro;
        Map<String, Room> roomsMap = new HashMap<>();

        private Builder() {
        }

        public static Builder aWorld() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withStartingRoom(Room startingRoom) {
            this.startingRoom = startingRoom;
            return this;
        }

        public Builder fromFile(String filename) {
            WorldSchema worldSchema = new YamlReader(filename).readYaml();
            Properties props = worldSchema.getProperties();
            this.intro = props.getProperty("greeting");
            this.name = props.getProperty("name");
            for(WorldSchema.RoomSchema room : worldSchema.getRooms()) {
                Room r = new Room(room.getName(), room.getDescription());
                r.setUuid(room.getUuid());
                for(WorldSchema.ItemSchema is : room.getItems()) {
                    Actor newItem = ItemFactory.get(is.getTypeName());
                    String testType = is.getType();
                    if(is.getType() != null) {
//                        System.out.println("World.Builder is setting type to: " + is.getType());
                        newItem.setType(is.getType());
                    }
                    String splash = is.getSplash();
                    if(splash != null) {
                        newItem.setSplash(splash);
                    }
                    r.addItem(newItem,
                            is.getSplash(),
                            is.isVisibility(),
                            is.isReceiver());
                }
                roomsMap.put(r.getUuid(), r);
            }
            for(WorldSchema.TraversalSchema traversalSchema : worldSchema.getTraversalSchemas()) {
                Room startRoom = roomsMap.get(traversalSchema.getStartingRoom());
                Traversal t = new Traversal(traversalSchema.getDirection(),
                        traversalSchema.getDescription(),
                        roomsMap.get(traversalSchema.getToRoom()));
                t.setSplash(traversalSchema.getSplash());
                startRoom.addTraversal(t);
            }
            this.startingRoom = roomsMap.get(props.getProperty("starting room"));
            return this;
        }

        public Builder withIntro(String intro) {
            this.intro = intro;
            return this;
        }

        public World build() {
            World world = new World(name);
            world.setStartingRoom(startingRoom);
            world.intro = this.intro;
            return world;
        }
    }
}
