package com.company.Items;

import com.company.Interactions.Item;

import java.util.Date;

/**
 * Created by andy on 3/7/18.
 */
public class Apple extends Item {

    private Date birthdate;
    private Date bestByDate;

    public Apple() {
        super("Apple", "An ordinary looking orange pencil", true);
        birthdate = new Date();
        bestByDate = new Date(birthdate.getTime() + 5*60);

    }

    @Override
    public String handle(String s) {
        if (s.equalsIgnoreCase("examine")) {
            return this.getDescription();
        } else {
            return "I don't know how to " + s + " an apple.";
        }
    }

    public String getDescription() {
        return "I am an apple and was born on " + birthdate.toString();
    }
}
