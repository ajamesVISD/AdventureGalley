package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Executable;
import org.vashonsd.AdventureGalley.Interactions.Item;
import org.vashonsd.AdventureGalley.Interactions.Response;

/**
 * Created by andy on 3/30/18.
 */
public class Reverse implements Executable {

    public Response execute(Actor a) {
        String name = a.getName();
        String result = "";
        for(int j=name.length()-1; j>=0; j--) {
            result += name.charAt(j);
        }
        return new Response(result, false);
    }

}
