package org.vashonsd.AdventureGalley;

import org.vashonsd.AdventureGalley.Interactions.Item;

public class Main {

    public static void main(String[] args) {
        Room curRoom = World.getWorld("Crazy").getStartingRoom();

        Reader input = new Reader();
        System.out.println(curRoom.getDescription());

        //prints out items in starter room for the player to see
        System.out.println("In this room, there is:");
        System.out.println(curRoom.listItemsInRoom());

        // offer help, since this is the player's first time playing
        String prompt = input.readLine(curRoom.getDescription()+ " Type your command. If you need help, type 'help'.");

        while(true) {
            String arr[] = prompt.split(" ", 2);
            String verb = arr[0];  //This is the verb
            String directObject = arr[1];

            if(curRoom.hasItem(directObject)) {
                Item whichItem = curRoom.getItem(directObject);
                String response = whichItem.handle(verb);
                System.out.println(response);
            } else if(curRoom.hasRoom(verb)) {
                curRoom = curRoom.getRoom(verb);
                System.out.println(curRoom.getDescription());
                System.out.print("In this room, there is:");
                System.out.print(curRoom.listItemsInRoom());
            }
            else if (verb.equalsIgnoreCase("look")) {
                System.out.println(curRoom.getDescription());
            }
            else if (verb.equalsIgnoreCase("quit")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                String quitPrompt = input.readLine();
                if(quitPrompt.equalsIgnoreCase("y")) {
                    System.out.println("Thanks for playing!");
                    break;
                }
                else {
                    System.out.println(curRoom.getDescription());
                }
            }
            else if (verb.equalsIgnoreCase("help")){
                System.out.println(listOfCommands());
            }
            else{
                System.out.println("You can't do that ");
            }
            prompt = input.readLine();
        }
    }

    
    public static String listOfCommands() {
            return ("Here's a list of useful commands: \nThe 'Look' command will " +
                    "give you a description of your surroundings. \nThe 'Examine' command will give you a description of an" +
                    "object. \nThe 'Inventory' command will give you a list of the items in your inventory and a description of" +
                    " them. \nThe 'Restart' command will restart the game \nThe 'Quit' command will quit the game for you. Make " +
                    "sure you save before you quit!");


    }
}
