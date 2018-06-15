package org.vashonsd.AdventureGalley;

import org.vashonsd.AdventureGalley.Interactions.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.vashonsd.Game;
import org.vashonsd.Message;

public class Pirateship implements Game {

    /**
     * A org.vashonsd.AdventureGalley.Game is just a Map of Players, mapped to usernames. Each Player class is expected to dispatch the input.
     */

    Map<String, Player> players;
    BlockingQueue<Message> queue;
    List<String> availableWorlds;
    Map<String, World> worlds;

    public Pirateship() {
        players = new HashMap<>();
        queue = new LinkedBlockingDeque<>();
        availableWorlds = new ArrayList<>();
        availableWorlds.add("home");
        worlds = new HashMap<>();
    }

    public void handle(Message m) {
        String uuid = m.getUuid();
        String text = m.getBody();
        String responseBody = "";
        //This captures the specific state that the player has not been initialized yet.
        if(!players.containsKey(uuid)) {
            Player p = new Player();
            p.setUuid(uuid);
            p.setOutboundMessages(queue);
            players.put(uuid, p);
            responseBody = "Choose a name for yourself: ";
        } else {
            Player player = players.get(uuid);
            if(!player.isReady()) {
                //walk through the unfinished fields in order.
                if(player.getName() == "") {
                    if(text.equals("")) {
                        responseBody = "You must enter a name";
                    } else {
                        player.setName(text);
                        responseBody = "Okay, your name is " + text + ".\n" +
                                "Now write a description for yourself. This is what other players will see.";
                    }
                } else if(player.getDescription() == "") {
                    player.setDescription(text);
                    responseBody = "Okay, now choose one of these worlds: ";
                    for(String name: availableWorlds) {
                        responseBody += "\n" + name;
                    }
                } else if(player.getCurrentRoom() == null) {
                    if(!availableWorlds.contains(text)) {
                        responseBody = "I'm sorry, " + text + " is not one of the available worlds."
                                + "Try one of these: "
                                + availableWorlds.toString();
                    } else {
                        if(!worlds.containsKey(text)) {
                            worlds.put(text, World.fromBuilder().fromFile(text).build());
                        }
                        World w = worlds.get(text);
                        player.setCurrentRoom(w.getStartingRoom());
                        player.setReady(true);
                        responseBody = w.getIntro();
                        responseBody += "\n" + w.getStartingRoom().getDescription();
                    }
                }
            } else {
                player.dispatch(text);
            }
        }
        queue.offer(new Message(uuid, responseBody));
    }

    public Message pull() {
        return queue.poll();
    }
}
