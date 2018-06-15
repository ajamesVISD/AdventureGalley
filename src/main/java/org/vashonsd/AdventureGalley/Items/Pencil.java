package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Take;

public class Pencil extends Item {

    public Pencil () {
        super("Pencil", "An ordinary looking orange pencil", false);
    }
    public Pencil(String name, String description) {
        super(name, description, false);
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
//    public void dispatch(String s) {
//        if(s.equalsIgnoreCase("examine")) {
//            return this.getDescription();
//        }
//        else if(s.equalsIgnoreCase("Paint")){
//            this.setDescription("The pencil now is yellow.");
//            return this.getDescription();
//        }
//        else if(s.equalsIgnoreCase("Write")) {
//            return "The Communist League, an international association of workers, which could of course be only a\n" +
//                    "secret one, under conditions obtaining at the time, commissioned us, the undersigned, at the\n" +
//                    "Congress held in London in November 1847, to write for publication a detailed theoretical and\n" +
//                    "practical programme for the Party. Such was the origin of the following Manifesto, the\n" +
//                    "manuscript of which travelled to London to be printed a few weeks before the February [French]\n" +
//                    "Revolution [in 1848]. First published in German, it has been republished in that language in at\n" +
//                    "least twelve different editions in Germany, England, and America. It was published in English for\n" +
//                    "the first time in 1850 in the Red Republican, London, translated by Miss Helen Macfarlane, and\n" +
//                    "in 1871 in at least three different translations in America. The French version first appeared in\n" +
//                    "Paris shortly before the June insurrection of 1848, and recently in Le Socialiste of New York. A\n" +
//                    "new translation is in the course of preparation. A Polish version appeared in London shortly after\n" +
//                    "it was first published in Germany. A Russian translation was published in Geneva in the sixties1\n" +
//                    ".\n" +
//                    "Into Danish, too, it was translated shortly after its appearance";
//        }
//        else {
//            return "I don't know how to "+ s + "a pencil";
//        }
//    }
}
