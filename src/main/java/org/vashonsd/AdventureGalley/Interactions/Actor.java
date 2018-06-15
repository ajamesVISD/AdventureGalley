package org.vashonsd.AdventureGalley.Interactions;

import org.vashonsd.AdventureGalley.Executables.Executable;
import org.vashonsd.AdventureGalley.Items.Item;
import org.vashonsd.AdventureGalley.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Actor {

    protected String name;
    protected String description;
    protected String uuid;
    protected String splash;

    /**
     * "conversations" is a Map of uuids : booleans, indicating if the current Player is in persistent
     * conversation with the user with the given id.
     */
    protected Map<String, Boolean> conversations;
    protected Inventory inventory;

    protected Map<String, Executable> availableCommands;

    public Actor(String name, String description) {
        this.name = name;
        this.description = description;
        availableCommands = new HashMap<String, Executable>();
        conversations = new HashMap<>();
        inventory = new Inventory();
        this.addExecutables();
    }

    protected abstract void addExecutables();

    public abstract void setType(String str);

    public Map<String, Placement> getVisible() {
        return inventory.visibleInInventory();
    }

    public Map<String, Placement> getReceivers() {
        return inventory.receiversInInventory();
    }

    public void addConversation(Player p) {
        conversations.put(p.getUuid(), true);
    }

    public void removeConversation(Player p) {
        conversations.put(p.getUuid(), false);
    }

    public boolean getConversationStatus(Player p) {
        if(!conversations.containsKey(p.getUuid())) {
            return false;
        } else {
            return conversations.get(p.getUuid());
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addExecutable(Executable e) {
        for(String keyword : e.getKeywords()) {
            availableCommands.put(keyword, e);
        }
    }

    public void addExecutable(Set<Executable> executables) {
        for(Executable e : executables) {
            addExecutable(e);
        }
    }

    public void removeExecutable(Executable e) {
        Set<String> keywords = e.getKeywords();
        for(String s : keywords) {
            availableCommands.remove(s);
        }
    }

    /**
     * The dispatch method accepts a word and figures out the proper reply
     * (in the form of a string) to that word.
     *
     * Please notice that the Response object is primarily used to indicate if the input text should go directly to this receiver.
     */
    public Response handle(String verb, Player player) {
        String resp = "";
        if(availableCommands.containsKey(verb)) {
            resp = availableCommands.get(verb).execute(this, player);
        } else {
            resp = String.format("I don't know how to %s a %s", verb, this.name);
        }
        String uuid = player.getUuid();
        //To automatically make this a persistent response, have the Executable switch the conversation on for the player.
        Response response = new Response(resp);
        if(this.getConversationStatus(player)) {
            response.setPersist(true);
            response.setReceiver(this);
        }
        return response;
    }

    public void addItem(Actor i) {
        inventory.addActor(i);
    }

    public void addItem(Actor i, String splash) {
        inventory.addActor(i, splash, true, true);
    }

    public void addItem(Actor i, String splash, boolean visible, boolean receiver) {
        inventory.addActor(i, splash, visible, receiver);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSplash() {
        return splash;
    }

    public void setSplash(String splash) {
        this.splash = splash;
    }
}
