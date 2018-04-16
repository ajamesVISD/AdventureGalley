package org.vashonsd.AdventureGalley;
import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class Reader {
    private Scanner input;


    public Reader() {
        input = new Scanner(System.in);
    }

    public int readInt(String prompt){
        System.out.print(prompt);
        int n = input.nextInt();
        input.nextLine();
        return n;
    }
    public String readLine(String prompt){
        System.out.print(prompt);
        System.out.println("");
        String str = input.nextLine();
        return str;
    }

    public String readLine() {
        return input.nextLine();
    }
}
