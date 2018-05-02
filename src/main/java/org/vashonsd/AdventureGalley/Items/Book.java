package org.vashonsd.AdventureGalley.Items;

import org.vashonsd.AdventureGalley.Interactions.Item;

public class Book extends Item {

    private String content;

    public Book() {
        super("book", "What a lovely book of magic spells.");
    }

    public Book(String name, String description,String content) {
        super(name, description);
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String handle(String s) {
        if (s.equalsIgnoreCase("examine")) {
            return this.getDescription();
        } else if (s.equalsIgnoreCase("vandalize")) {
            this.setDescription("This book's title has been crossed out and now says \"The Communist Manifesto\"");
            this.setContent("The history of all hitherto existing society(2) is the history of class struggles.\n" +
                    "\n" +
                    "Freeman and slave, patrician and plebeian, lord and serf, guild-master(3) and journeyman, in a word, oppressor and oppressed, stood in constant opposition to one another, carried on an uninterrupted, now hidden, now open fight, a fight that each time ended, either in a revolutionary reconstitution of society at large, or in the common ruin of the contending classes.\n" +
                    "\n" +
                    "In the earlier epochs of history, we find almost everywhere a complicated arrangement of society into various orders, a manifold gradation of social rank. In ancient Rome we have patricians, knights, plebeians, slaves; in the Middle Ages, feudal lords, vassals, guild-masters, journeymen, apprentices, serfs; in almost all of these classes, again, subordinate gradations.\n" +
                    "\n" +
                    "The modern bourgeois society that has sprouted from the ruins of feudal society has not done away with class antagonisms. It has but established new classes, new conditions of oppression, new forms of struggle in place of the old ones.\n" +
                    "\n" +
                    "Our epoch, the epoch of the bourgeoisie, possesses, however, this distinct feature: it has simplified class antagonisms. Society as a whole is more and more splitting up into two great hostile camps, into two great classes directly facing each other — Bourgeoisie and Proletariat.\n" +
                    "\n" +
                    "From the serfs of the Middle Ages sprang the chartered burghers of the earliest towns. From these burgesses the first elements of the bourgeoisie were developed.\n" +
                    "\n" +
                    "The discovery of America, the rounding of the Cape, opened up fresh ground for the rising bourgeoisie. The East-Indian and Chinese markets, the colonisation of America, trade with the colonies, the increase in the means of exchange and in commodities generally, gave to commerce, to navigation, to industry, an impulse never before known, and thereby, to the revolutionary element in the tottering feudal society, a rapid development.\n" +
                    "\n" +
                    "The feudal system of industry, in which industrial production was monopolised by closed guilds, now no longer sufficed for the growing wants of the new markets. The manufacturing system took its place. The guild-masters were pushed on one side by the manufacturing middle class; division of labour between the different corporate guilds vanished in the face of division of labour in each single workshop.\n" +
                    "\n" +
                    "Meantime the markets kept ever growing, the demand ever rising. Even manufacturer no longer sufficed. Thereupon, steam and machinery revolutionised industrial production. The place of manufacture was taken by the giant, Modern Industry; the place of the industrial middle class by industrial millionaires, the leaders of the whole industrial armies, the modern bourgeois.\n" +
                    "\n" +
                    "Modern industry has established the world market, for which the discovery of America paved the way. This market has given an immense development to commerce, to navigation, to communication by land. This development has, in its turn, reacted on the extension of industry; and in proportion as industry, commerce, navigation, railways extended, in the same proportion the bourgeoisie developed, increased its capital, and pushed into the background every class handed down from the Middle Ages.\n" +
                    "\n" +
                    "We see, therefore, how the modern bourgeoisie is itself the product of a long course of development, of a series of revolutions in the modes of production and of exchange.\n" +
                    "\n" +
                    "Each step in the development of the bourgeoisie was accompanied by a corresponding political advance of that class. An oppressed class under the sway of the feudal nobility, an armed and self-governing association in the medieval commune(4): here independent urban republic (as in Italy and Germany); there taxable “third estate” of the monarchy (as in France); afterwards, in the period of manufacturing proper, serving either the semi-feudal or the absolute monarchy as a counterpoise against the nobility, and, in fact, cornerstone of the great monarchies in general, the bourgeoisie has at last, since the establishment of Modern Industry and of the world market, conquered for itself, in the modern representative State, exclusive political sway. The executive of the modern state is but a committee for managing the common affairs of the whole bourgeoisie.");
            return this.getDescription();
        }
        else if(s.equalsIgnoreCase("read")){
            return content;
        }
        else {
            return "I don't know how to " + s + " a book.";
        }
}
}
