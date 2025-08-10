package game.items;

import edu.monash.fit2099.engine.items.Item;

/**
 * Purchasable interface for purchasable items
 */
public interface Purchasable {
    /**
     * Returns the price of item after any discounts or modifications
     * @return  New price of item
     */
    int getPrice();

    /**
     * Returns the original price of object before any discounts or modifications
     * @return  Original price of item
     */
    int getOriginalPrice();

    /**
     * Returns the Item that is linked to the Purchasable
     * @return  Item purchased
     */
    Item getItem();
}
