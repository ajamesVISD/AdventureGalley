package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Actor;

public class ChatBot extends Actor {

    final String quitWord = "quit";

    public ChatBot(String name, String description) {
        super(name, description);
    }

    @Override
    protected void addExecutables() {

    }

    @Override
    public void setType(String str) {

    }


    public String start() {
        return "Greetings! I am a ChatBot.";
    }


}
