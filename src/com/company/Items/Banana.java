package com.company.Items;

import com.company.Interactions.Item;
import com.company.Executables.*;

/**
 * Created by andy on 3/5/18.
 */
public class Banana extends Item {

    public Banana() {
        super("banana", "a delicious yellow banana.", true);
        addExecutable("examine", new Examine());
        addExecutable("reverse", new Reverse());
        addExecutable("punch", new Punch());
    }
}
