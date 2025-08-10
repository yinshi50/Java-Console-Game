package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

/**
 * Class that represents a Pickle Jar
 */
public class PickleJar extends Consumables implements Sellables{

    /**
     * the sell credits
     */
    int sellCredits = 25;

    /**
     * the sell credits after premium
     */
    int premiumCredits = 50;

    /**
     *  the rate of getting premium
     */
    int premiumRate = 50;

    Random r = new Random();
    /**
     * Constructor
     */
    public PickleJar(){
        super("Pickle Jar", 'n', true, 1);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    /**
     * This gets an integer
     * @return the heal point of the consumable
     */
    public int getHealPoint(){
        double random = Math.random();
        if (random < 0.5){
            return -1;
        }
        else{
            return 1;
        }
    }

    /**
     * Return a new consumable item
     * @return  New consumable item object
     */
    @Override
    public Item getItem(){
        return new PickleJar();
    }

    /**
     * get the actual sell credits when being sold.
     * @return actual sell credits
     */
    @Override
    public int getSellCredits(){
        if (1 + r.nextInt(100) < this.premiumRate){
            return this.premiumCredits;
        }else{
            return this.sellCredits;
        }
    }

    /**
     * get the original sell credits
     * @return original sell credits
     */
    @Override
    public int getOriginalSellCredits(){
        return this.sellCredits;
    }
}
