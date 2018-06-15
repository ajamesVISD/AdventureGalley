package org.vashonsd.AdventureGalley.Minigames;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Play;
import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Response;

import org.vashonsd.Games.MinigameFactory;
import org.vashonsd.Utils.Minigame;

import java.util.HashMap;
import java.util.Map;

public class MinigameAdapter extends Actor {

    private final Map<String, Minigame> activeGames = new HashMap<>();
    private Minigame exemplar;
    private String quitWord = "";

    public MinigameAdapter() {
        super("", "");
        addExecutable(new Examine());
        addExecutable(new Play());
    }

    @Override
    public Response handle(String verb, Player player) {
        Response resp = new Response("");
        if(getConversationStatus(player)) {
            Minigame minigame = activeGames.get(player.getUuid());
            if(verb.equalsIgnoreCase(quitWord)) {
                this.removeConversation(player);
                resp.setText(minigame.quit());
                removePlayer(player);
            } else {
                resp.setText(minigame.handle(verb));
                resp.setPersist(true);
                resp.setReceiver(this);
            }
            return resp;
        } else {
            return super.handle(verb, player);
        }
    }

    public String enrollPlayer(Player p) {

        Minigame newMinigame = null;
        try {
            newMinigame = exemplar.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        activeGames.put(p.getUuid(), newMinigame);
        return newMinigame.start();
    }

    public void removePlayer(Player p) {
        activeGames.remove(p.getUuid());
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Play());
    }

    @Override
    public void setType(String str) {
        exemplar = MinigameFactory.getGame(str);
        this.setName(str);
        this.quitWord = exemplar.getQuitWord();
    }
}
