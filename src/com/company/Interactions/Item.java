package com.company.Interactions;

import java.util.HashMap;

public abstract class Item {
    private String name;
    private String description;
    private boolean edible;

    private HashMap<String, Executable> availableCommands;


    public Item(String name, String description, boolean edible) {
        this.name = name;
        this.description = description;
        this.edible = edible;
        availableCommands = new HashMap<String, Executable>();
    }

    public Item() {

    }

    public void addExecutable(String s, Executable e) {
        availableCommands.put(s, e);
    }

    /*
    The handle method accepts a word and figures out the proper reply
    (in the form of a string) to that word.
     */
    public String handle(String s) {
        if(availableCommands.containsKey(s)) {
            return availableCommands.get(s).execute(this);
        } else {
            return String.format("I don't know how to %s a %s", s, this.name);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }
}
