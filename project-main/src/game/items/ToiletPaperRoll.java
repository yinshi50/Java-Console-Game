package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

/**
 * Class to represent ToiletPaperRoll
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellables{

    /**
     * Price of ToiletPaperRoll
     */
    int price = 5;

    /**
     * Chance of rare occurrence to happen
     */
    int rareChance = 75;

    /**
     * Randomizer
     */
    Random r = new Random();

    /**
     * the sell credits
     */
    int sellCredits = 1;

    /**
     * the chance of killing the player
     */
    int killRate = 50;

    /***
     * Constructor.
     */
    public ToiletPaperRoll() {
        super("toilet paper roll", 's', true);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    @Override
    public int getPrice() {
        if (1 + r.nextInt(100) < rareChance) {
            return 1;
        }
        return price;
    }

    @Override
    public int getOriginalPrice() {
        return price;
    }

    /**
     * get the item
     * @return item
     */
    @Override
    public Item getItem() {
        return new ToiletPaperRoll();
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
     * present the rate of killed when selling a particular type of item (set to default method
     * @return the percentage of being killed when selling this item
     */
    @Override
    public int getKillRate(){
        return this.killRate;
    }
}
