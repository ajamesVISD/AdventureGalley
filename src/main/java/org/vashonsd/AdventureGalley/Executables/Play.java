package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Minigames.MinigameAdapter;

public class Play extends Executable {

    public Play() {
        addKeyword("play");
    }

    @Override
    public String execute(Actor a, Player player) {
        a.addConversation(player);
        System.out.println("now playing: " + a.getName());
        if(a.getClass() == MinigameAdapter.class) {
            MinigameAdapter ad = (MinigameAdapter)a;
            a.addConversation(player);
            return ad.enrollPlayer(player);
        }
        return "I'm lost here";
    }
}
