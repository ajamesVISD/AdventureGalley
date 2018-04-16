package org.vashonsd.AdventureGalley;

public class Player {
    private Inventory inventory;
    private String name;
    public int health = 100;
    public int hunger = 25;

    public Player(String name) {
        this.name = name;
        inventory = new Inventory();

    }
    public int getHealth(){
        return health;
    }
    public int getHunger(){
        return hunger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPlayerState(){
        return ("You currently have: "+ getHealth() +" Health and "+getHunger()+" Hunger");
   }
    public void youDied(){
        health=0;
        System.out.println("you died");
        System.exit(0);
    }




}
