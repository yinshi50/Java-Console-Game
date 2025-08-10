package game.behaviour;

import edu.monash.fit2099.engine.items.Item;

/**
 * Interface for Spawnable items
 */
public interface Spawnable {

    /**
     * Method to return spawn chance of item
     * @return  Spawn chance for item
     */
    int getSpawnChance();

    /**
     * Method to get new object of Item
     * @return  New item object
     */
    Item getItem();
}
