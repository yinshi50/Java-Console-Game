package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.behaviour.Spawnable;

/**
 * Class to represent SmallFruit
 */
public class SmallFruit extends Consumables implements Spawnable {

    private int spawnChance = 30;

    /**
     * Constructor
     */
    public SmallFruit() {
        super("small fruit", 'o', true, 1);
    }

    @Override
    public Item getItem() {
        return new SmallFruit();
    }

    @Override
    public int getSpawnChance() {
        return spawnChance;
    }
}
