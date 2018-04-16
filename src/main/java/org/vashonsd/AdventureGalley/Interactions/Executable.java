package org.vashonsd.AdventureGalley.Interactions;

/**
 * Executable allows us to create Executables that take an Item and use
 * its properties to return a String.
 *
 * Example: Examine calls the Item's getDescription() method and returns
 * the result as a String.
 */
public interface Executable {

    /**
     * Uses the properties and methods of the Item to return a String.
     */
    String execute(Item i);
}
