package com.company.Executables;

import com.company.Interactions.Executable;
import com.company.Interactions.Item;


    public class Punch implements Executable{

        @Override
        public String execute(Item i) {
            i.setDescription(i.getDescription()+" with a fist shaped dent in it");
            return i.getDescription();
        }
    }

