package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

/**
 * Class to represent Large Bolts
 */
public class LargeBolts extends Item implements Sellables {

    /**
     * the sell credits
     */
    int sellCredits = 25;

    /**
     * Constructor
     */
    public LargeBolts() {
        super("large bolts", '+', true);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    /**
     * get the actual sell credits when being sold.
     * @return actual sell credits
     */
    @Override
    public int getSellCredits(){
        return this.sellCredits;
    }

    /**
     * get the original sell credits
     * @return original sell credits
     */
    @Override
    public int getOriginalSellCredits(){
        return this.sellCredits;
    }

    /**
     * get the item
     * @return item
     */
    @Override
    public Item getItem(){
        return new LargeBolts();
    }
}
