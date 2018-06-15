package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Minigames.MinigameAdapter;

public class ItemFactory {

    public static Actor get(String which) {
        switch (which){
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "baseball":
                return new Baseball();
            case "book":
                return new Book();
            case "mug":
                return new Mug();
            case "pencil":
                return new Pencil();
            case "sickle":
                return new Sickle();
            case "minigame":
                return new MinigameAdapter();
            default:
                throw new IllegalArgumentException("No such Item type: " + which);
        }
    }
}
