package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

import java.util.Random;

/**
 * Class to represent EnergyDrink
 */
public class EnergyDrink extends Consumables implements Purchasable{

    /**
     * Randomizer
     */
    Random r = new Random();

    /**
     * Chance of rare occurrence to happen
     */
    int rareChance = 20;

    /**
     * Price of EnergyDrink
     */
    int price = 10;

    /***
     * Constructor.
     */
    public EnergyDrink() {
        super("energy drink", '*', true, 1);
    }

    @Override
    public int getPrice() {
        if (1 + r.nextInt(100) < rareChance) {
            return 2 * price;
        }
        return price;
    }

    @Override
    public int getOriginalPrice() {
        return price;
    }

    @Override
    public Item getItem() {
        return new EnergyDrink();
    }
}
