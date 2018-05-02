package org.vashonsd.AdventureGalley.Interactions;

import java.util.HashMap;

/**
 * Created by andy on 5/1/18.
 */
public class Actor {
    private String name;
    private String description;

    private Inventory inventory;

    private HashMap<String, Executable> availableCommands;

    /**
     *
     * Represents any element of our world, capable of receiving and sending messages.
     *
     * Actors can be in the inventory of other Actors, and can have other Actors in their inventory.
     *
     * Actors each keep their own store of commands, allowing the actor to execute an Executable in response to a keyword.
     *
     * Item, Room, and Player all subclass from Actor.
     */
    public Actor(String name, String description) {
        this.name = name;
        this.description = description;
        inventory = new Inventory();
        availableCommands = new HashMap<String, Executable>();
    }

    /**
    * Adds an Executable to this Actor's storehouse, with a verb as a keyword.
    *
    * For instance, if we add the Examine executable with the key "examine," then
    * this Actor can now handle the command to "examine [name of item]."
    *
    * If, for example, our Item is an Apple, we might want to be able to receive the user's command
    * "examine apple." If we have the keyword "examine" enrolled, then "examine" will pull up its
    * instance of the Examine executable and call its Execute method.
    *
    * @param s The key (usually a verb) that will find the Executable.
    * @param e The Executable that will be executed.
    * */
    public void addExecutable(String s, Executable e) {
        availableCommands.put(s, e);
    }

    /**
    * Given a Request sent to this object, finds an Executable to handle this request.
    *
    * We assume that this object is capable of handling this Request. Our engine should first check
     * the canHandle() method and return a "you can't do that" Response if the result is false.
    *
    * @param req The Request to be handled.
    *
    * @return A Response instance.
    * */
    public Response handle(Request req) {
        return availableCommands.get(req.getVerb()).execute(this);
    }

    /**
     * Tells us whether the Actor can handle a certain keyword or not.
     *
     * We would expect that "canyon" can handle "examine" but not "eat."
     *
     * @param s The keyword we are searching for.
     * @return True or false is the Actor can handle the keyword.
     */
    public boolean canHandle(String s) {
        return availableCommands.containsKey(s);
    }

    /**
     * Returns the name of the Actor.
     *
     * @return A String representing the name of the Actor.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Actor. The name should match the word(s) we expect the user to type to find
     * the object in question (e.g., "sword," "angry accountant," "doorway").
     *
     * @param name A String representing the name of the Actor.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the current description of the Actor.
     *
     * @return A String representing the description of the Actor.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Actor.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public void addItem(Actor a) {
        inventory.addItem(a);
    }

    public boolean hasItem(String s) {
        return inventory.hasItem(s);
    }

    public Actor getItem(String s) {
        return inventory.getActor(s);
    }
}
