package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;

/**
 * Class that represents a Buy action
 */
public class BuyAction extends Action {
    /**
     * Item to be purchased
     */
    Purchasable item;
    /**
     * Price of item
     */
    int itemPrice;

    /**
     * Constructor
     * @param item  Item to be purchased
     */
    public BuyAction(Purchasable item) {
        this.item = item;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        this.itemPrice = item.getPrice();
        if (actor.getBalance() < itemPrice){
            return actor + " has insufficient credits to purchase " + item;
        }
        actor.deductBalance(itemPrice);
        Item purchasedItem = item.getItem();
        if (purchasedItem != null) {
            actor.addItemToInventory(purchasedItem);
        }
        return actor + " has purchased " + item + " for " + itemPrice + " credits";
    }

    @Override
    public String menuDescription(Actor actor) {
        this.itemPrice = item.getOriginalPrice();
        return actor + " purchases " + item + " for " + itemPrice + " credits";
    }
}
