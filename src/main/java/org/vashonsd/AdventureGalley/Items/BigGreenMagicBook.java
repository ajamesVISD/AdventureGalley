package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Item;

public class BigGreenMagicBook extends Item {


    public BigGreenMagicBook(){
        super("Big Green Magic Book", "A super boring book written by Karl Marx and Friedrich Engels... but magical", false);
    }
    @Override
    public String handle (String s) {
        if(s.equalsIgnoreCase("examine")){
            return this.getDescription();
        }
        else{
            return "I don't know how to" + s + "a Big Green Magic Book.";
        }
    }
}
