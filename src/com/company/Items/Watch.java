package com.company.Items;
import com.company.Executables.Examine;
import com.company.Executables.GetTime;
import com.company.Interactions.Item;

import java.util.Calendar;

public class Watch extends Item {


    public Watch() {
        super("watch","current time", false);
        addExecutable("time",new GetTime());
        addExecutable("examine",new Examine());
    }

    @Override
    public String getDescription() {
        Calendar test = Calendar.getInstance();
        return test.getTime().toString();
    }
}
