package org.vashonsd.AdventureGalley.Executables;

import org.vashonsd.AdventureGalley.Interactions.Actor;
import org.vashonsd.AdventureGalley.Interactions.Player;
import org.vashonsd.AdventureGalley.Items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Executable allows us to create Executables that take an Item and use
 * its properties to return a String.
 *
 * Example: Examine calls the Item's getDescription() method and returns
 * the result as a String.
 */
public abstract class Executable {

    protected static Set<String> lexicon = new HashSet<String>();

    protected Set<String> keywords;

    public static Set<String> getLexicon() {
        return lexicon;
    }

    public static boolean inLexicon(String str) {
        return lexicon.contains(str);
    }

    public static Set<Executable> getExecutableSets(String keyword) {
        Set<Executable> result = new HashSet<>();
        switch(keyword) {
            case ("small item"):
                result.add(new Examine());
                result.add(new Take());
        }
        return result;
    }

    protected void addKeyword(String str) {
        lexicon.add(str);
        this.keywords.add(str);
    }

    public Executable() {
        keywords = new HashSet<String>();
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    /**
     * Uses the properties and methods of the Item to return a String.
     */
    public abstract String execute(Actor a, Player player);
}
