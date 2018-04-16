package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Item;

public class Mug extends Item {
    public Mug(){
        super("Mug","An artisan mug",false);
    }
    public String handle(String s){
        if(s.equalsIgnoreCase("examine")){
            return this.getDescription();
        }
        else if(s.equalsIgnoreCase("break")){
            this.setDescription("Shards of Artisan pottery.");
            return this.getDescription();
        }
        else{
            return "I don't know how to "+s+" a Mug.";
        }
    }
}
