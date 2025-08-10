package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumables;

/**
 * Class that represents a Heal action
 */
public class ConsumeAction extends Action {

    /**
     * Item used for healing the Actor
     */
    private Consumables healingItem;

    /**
     * How much health the item heals the Actor
     */
    private int healPoint;

    /**
     * Constructor
     *
     * @param item  Item used to heal the Actor
     */
    public ConsumeAction(Consumables item) {
        this.healingItem = item;
        this.healPoint = item.getHealPoint();
    }

    /**
     * Executes the action of an actor consuming a healing item. This action heals the actor for a specified
     * number of points and removes the healing item from the actor's inventory.
     *
     * @param actor The actor performing the action.
     * @param map   The game map where the action takes place.
     * @return A description of the action performed.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.heal(healPoint);
        actor.removeItemFromInventory(healingItem);
        return actor + " consumes " + healingItem + " and heals " + actor + " for " + healPoint + " points.";
    }

    /**
     * Provides a description of the action to be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return A description of the action for the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        if (healPoint < 0){
            return actor + " consumes " + healingItem + " for " +  (healPoint * -1) + " points.";
        }
        return actor + " consumes " + healingItem + " for " + healPoint + " points.";
    }
}
