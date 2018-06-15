package org.vashonsd.AdventureGalley.Interactions;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Executable;
import org.vashonsd.AdventureGalley.Items.Traversal;
import org.vashonsd.AdventureGalley.Response;
import org.vashonsd.AdventureGalley.Room;

import org.vashonsd.Message;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Player extends Actor {
    private String uuid;
    protected int health = 100;
    protected int hunger = 25;

    private Scope scope;
    private Actor target;

    private BlockingQueue<Message> outboundMessages;

    private boolean ready;
    Room currentRoom;

    public Player(String name, String description) {
        super(name, description);
        scope = new Scope();
        addExecutable(new Examine());
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
    }

    @Override
    public void setType(String str) {

    }

    public Player() {
        super("", "");
        ready = false;
        scope = new Scope();
    }

    public void setOutboundMessages(BlockingQueue<Message> outboundMessages) {
        this.outboundMessages = outboundMessages;
    }

    public void dispatch(String s) {
//        System.out.println(Executable.getLexicon());
        scope.scopeFor(this);
        String result;
        List<String> words = Arrays.asList(s.split(" "));
        String verb = "";
        String object = "";
        String spacer = "";
        boolean found = false;
        Response resp = new Response("");
        if(target != null) {
//            System.out.println("Currently writing to: " + target.getName());
            resp = target.handle(s, this);
        } else {
            for (String word : words) {
                if (!found) {
                    verb += spacer + word;
                    spacer = " ";
                    if (Executable.inLexicon(verb)) {
                        found = true;
                        spacer = "";
                    }
                } else {
                    object += spacer + word;
                    spacer = " ";
                }
            }
            if (found) {
                if (object.equals("")) {
                    object = "omniscient";
                }
                if (scope.contains(object)) {
                    resp = scope.get(object).handle(verb, this);
                } else {
                    publish("What do you want to " + verb + "?");
                }
            } else {
                if (scope.contains(object)) {
                    if(scope.get(object).getClass() == Traversal.class) {
                        resp = scope.get(object).handle("go", this);
                    } else {
                        publish("What about the " + object + "?");
                    }
                }
                publish("Come again?");
            }
        }
        if (resp.isPersist()) {
            target = resp.getReceiver();
        } else {
            if(target != null) {
                removeTarget();
            }
        }
        publish(resp.getText());
    }

    public void publish(String s) {
        outboundMessages.offer(new Message(uuid, s));
    }

    /**
     * Sends a message to all the other Players in the room.
     * @param s
     */
    public void broadcast(String s) {
        for(Player p : getCurrentRoom().getInventory().playersInInventory().values()) {
            if(!p.equals(this)) {
                outboundMessages.offer(new Message(p.getUuid(), s));
            }
        }
    }

    public int getHealth(){
        return health;
    }
    public int getHunger(){
        return hunger;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        if(currentRoom != null) {
            currentRoom.removeActor(this);
            broadcast(getName() + " is leaving!");
        }
        currentRoom = newRoom;
        newRoom.addItem(this, getName() + " is here.");
        broadcast(getName() + " has entered!");
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Actor getTarget() {
        return target;
    }

    public void setTarget(Actor target) {
        this.target = target;
    }

    public void removeTarget() {
        this.target = null;
        publish(getCurrentRoom().getDescription());
    }

    public String getPlayerState(){
        return ("You currently have: "+ getHealth() +" Health and "+getHunger()+" Hunger");
   }
    public void youDied(){
        health=0;
        System.out.println("you died");
        System.exit(0);
    }
}
