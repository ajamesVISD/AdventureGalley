package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;

/**
 * Created by andy on 3/30/18.
 */
public class Reverse extends Executable {

    public Reverse() {
        super();
        addKeyword("reverse");
    }

    public String execute(Actor a, Player player) {
        String name = a.getName();
        String result = "";
        for(int j=name.length()-1; j>=0; j--) {
            result += name.charAt(j);
        }
        return result;
    }
}
