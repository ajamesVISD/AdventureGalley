package org.vashonsd.AdventureGalley;

import org.vashonsd.Message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TestMain {

    static Pirateship pirateship;

    public static void main(String[] args) {
        pirateship = new Pirateship();
        InputStream inputStream = System.in;
        Scanner in = new Scanner(inputStream);
        String input = "";
        Message output;
        while(!input.equalsIgnoreCase("quit")) {
            try {
                if(inputStream.available() > 0) {
                    pirateship.handle(new Message("james.elliott", in.nextLine()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if((output = pirateship.pull()) != null) {
                System.out.println(output.getBody());
            }
        }
        System.out.println("Bye bye!");
    }
}
