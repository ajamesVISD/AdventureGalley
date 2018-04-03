package com.company;

import com.company.Items.*;

public class World {
    String name;
    Room startingRoom;


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

    public Room getStartingRoom() {
        return startingRoom;
    }

    public Room setStartingRoom(Room r) {
        startingRoom = r;
        return r;
    }

    public static World originalWorld(){
        World thisWorld = new World("CrazyWorld");

        Room home = new Room("home", "You are in a simple gray room.");
        Room cave = new Room("cave", "This room glitters with jewels.");
        Room arcade = new Room("arcade","This  room is full of skee ball courts");
        Room garage = new Room("garage","this room is full of cardboard boxes");

        home.addItem(new Book("book","it is a book","these are some words"));
        home.addItem(new Apple());
        home.addItem(new Banana());
        home.addItem(new Hammer());
        home.addItem(new Watch());
        garage.addItem(new Mug());
        arcade.addRoom(home);
        arcade.addRoom(cave);

        arcade.addItem(new Apple());

        home.addRoom(garage);
        home.addRoom(cave);
        home.addRoom(arcade);

//        home.itemsInRoom.addItem(new Banana());
//        home.itemsInRoom.addItem(new Item("note", "Welcome to our game.", false));
//        garage.itemsInRoom.addItem(new Item("Hammer", "A very heavy duty hammer.", false));
//        garage.itemsInRoom.addItem(new Item("Drill","Does not come with a drill bit.", false));
//        arcade.itemsInRoom.addItem(new Item("controller", "This is a video game controller or an unknown game system.", false));
//        arcade.itemsInRoom.addItem(new Item("jacket", " 80's style jacket with teal and purple detailing.", false));
//        cave.itemsInRoom.addItem(new Item("charcoal stick", " A stick of charcoal that looks like it has been on the walls", false));
//        cave.itemsInRoom.addItem(new Item("arrowhead", "An arrowhead make out of what seems to be some sort of bone", false));

        garage.addRoom(home);
        garage.addRoom(arcade);

        cave.addRoom(garage);
        cave.addRoom(home);
        thisWorld.setStartingRoom(home);
        return thisWorld;
    }




}
