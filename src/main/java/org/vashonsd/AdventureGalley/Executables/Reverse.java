package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Executable;
import org.vashonsd.AdventureGalley.Interactions.Item;

/**
 * Created by andy on 3/30/18.
 */
public class Reverse implements Executable {

    public String execute(Item i) {
        String name = i.getName();
        String result = "";
        for(int j=name.length()-1; j>=0; j--) {
            result += name.charAt(j);
        }
        return result;
    }
}
