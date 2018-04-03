package com.company.Executables;
import java.util.Calendar;
import com.company.Interactions.Executable;
import com.company.Interactions.Item;

public class GetTime implements Executable {

    @Override
    public String execute(Item i) {
        Calendar test = Calendar.getInstance();
        return test.getTime().toString();
    }
}