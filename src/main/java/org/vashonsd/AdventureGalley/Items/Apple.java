package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Item;

import java.util.Date;

/**
 * Created by andy on 3/7/18.
 */
public class Apple extends Item {

    private Date birthdate;
    private Date bestByDate;

    public Apple() {
        super("Pencil", "An ordinary looking orange pencil");
        birthdate = new Date();
        bestByDate = new Date(birthdate.getTime() + 5*60);
    }

    @Override
    public String getDescription() {
        return "I am an apple and was born on " + birthdate.toString();
    }
}
