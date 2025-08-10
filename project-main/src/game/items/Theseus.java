package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.TeleportAction;

/**
 * Class to represent a teleport item Theseus
 *
 * This item is purchasable and can be used to teleport to random location on the current map by the user
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 *
 */
public class Theseus extends Item implements Purchasable{

    /**
     * Price of Theseus
     */
    int price = 100;

    /**
     * Constructor
     *
     * Theseus is represented as '^' on the map
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getOriginalPrice() {
        return price;
    }

    @Override
    public Item getItem() {
        return new Theseus();
    }

    @Override
    public ActionList allowableActions(Location location) {
        ActionList action = super.allowableActions(location);

        // actor can only use THESEUS if they have to ability to do so

        // check if the actor on top of the item has the ability to use teleport item
        if (location.getActor().hasCapability(Ability.TELEPORT)){
            action.add(new TeleportAction(location.getActor(), location, this)); // if yes, actor gets an action to teleport with Theseus
        }
        return action;
    }

}
