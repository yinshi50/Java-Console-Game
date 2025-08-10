package game.items;

import edu.monash.fit2099.engine.items.Item;

/**
 * create an interface of Sellables
 */
public interface Sellables {

    /**
     * get the actual sell credits when being sold.
     * @return actual sell credits
     */
    int getSellCredits();

    /**
     * get the original sell credits
     * @return original sell credits
     */
    int getOriginalSellCredits();

    /**
     * get the item
     * @return item
     */
    Item getItem();

    /**
     * present the rate of killed when selling a particular type of item (set to default method
     * @return the percentage of being killed when selling this item
     */
    default int getKillRate(){
        return 0;
    }
}
