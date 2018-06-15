package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Items.ChatBot;
import org.vashonsd.AdventureGalley.Response;

public class TalkTo extends Executable {

    public TalkTo() {
        super();
        addKeyword("talk");
        addKeyword("talk to");
    }

    @Override
    public String execute(Actor a, Player player) {
        ChatBot chatBot = new ChatBot("na","not important");
        chatBot.addConversation(player);
        return chatBot.start();
    }
}
