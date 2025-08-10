package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

/**
 * Class to represent MetalSheets
 */
public class MetalSheets extends Item implements Sellables{

    /**
     * the sell credits
     */
    int sellCredits = 20;

    /**
     * the discount rate
     */
    int discountRate = 60;

    /**
     * the sell credit after having the discount
     */
    int discountSellCredits = 10;

    Random r = new Random();

    /**
     * Constructor
     */
    public MetalSheets() {
        super("metal sheets", '%', true);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    /**
     * get the actual sell credits when being sold.
     * @return actual sell credits
     */
    @Override
    public int getSellCredits(){
        if (1 + r.nextInt(100) < this.discountRate){
            return this.discountSellCredits;
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

    /**
     * get the item
     * @return item
     */
    @Override
    public Item getItem(){
        return new MetalSheets();
    }
}