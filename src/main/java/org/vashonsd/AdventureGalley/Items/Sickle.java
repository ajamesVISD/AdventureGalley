package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Take;

public class Sickle extends Item {

    public Sickle() {
        super("sickle", "Communism is not love. Communism is a hammer which we use to crush the enemy", false);
    }

    @Override
    protected void addExecutables() {
        addExecutable(new Examine());
        addExecutable(new Take());
    }

    @Override
    public void setType(String str) {

    }
//    @Override
//    public void dispatch (String s) {
//        if(s.equalsIgnoreCase("examine")){
//            return this.getDescription();
//        }
//        else if(s.equalsIgnoreCase("What's your purpose?")){
//            return "TO ABOLISH THE BOURGEOISIE!";
//        }
//        else if(s.equalsIgnoreCase("When were you born?")){
//            return "October 1917... what a great time";
//        }
//        else{
//            return "I don't know how to" + s + "a sickle.";
//        }
//    }
}