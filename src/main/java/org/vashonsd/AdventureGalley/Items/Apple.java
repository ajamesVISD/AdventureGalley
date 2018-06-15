package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Executables.Examine;
import org.vashonsd.AdventureGalley.Executables.Executable;

import java.util.Date;

/**
 * Created by andy on 3/7/18.
 */
public class Apple extends Item {

    private Date birthdate;
    private Date bestByDate;

    public Apple() {
        super("apple", "A delicious looking apple", true);
        birthdate = new Date();
        bestByDate = new Date(birthdate.getTime() + 5*60);
    }

    @Override
    protected void addExecutables() {
        addExecutable(Executable.getExecutableSets("small item"));
    }

    @Override
    public void setType(String str) {

    }

    public String getDescription() {
        return "I am an apple and was born on " + birthdate.toString();
    }
}
