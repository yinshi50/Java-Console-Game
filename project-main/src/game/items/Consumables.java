package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * Abstract class that represents Consumables
 */
public abstract class Consumables extends Item{

    private int healPoint;
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     * @param healPoint how much the Consumable heals the actor when consumed
     */
    public Consumables(String name, char displayChar, boolean portable, int healPoint) {
        super(name, displayChar, portable);
        this.healPoint = healPoint;
    }

    /**
     * Return how much an item heals for when consumed
     * @return  Value of heal point
     */
    public int getHealPoint() {
        return healPoint;
    };

    /**
     * Return a new consumable item
     * @return  New consumable item object
     */
    public Item getItem(){
        return null;
    };

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
