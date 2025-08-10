package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.behaviour.Spawnable;

/**
 * Class to represent LargeFruit
 */
public class LargeFruit extends Consumables implements Spawnable, Sellables {

    /**
     * the sell credits
     */
    int sellCredits = 30;
    private int spawnChance = 20;

    /**
     * Constructor
     */
    public LargeFruit() {
        super("large fruit", 'O', true, 2);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    /**
     * get the item
     * @return item
     */
    @Override
    public Item getItem() {
        return new LargeFruit();
    }

    @Override
    public int getSpawnChance() {
        return spawnChance;
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
}
