package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

/**
 * Class to represent MetalPipe
 */
public class MetalPipe extends WeaponItem implements Sellables{

    /**
     * the sell credits
     */
    int sellCredits = 35;

    /**
     * Constructor
     */
    public MetalPipe() {
        super("metal pipe", '!', 1, "bonks", 20);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    /**
     * allowable actions
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @ return the action list that contains the AttackAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList action = super.allowableActions(otherActor, location);
        action.add(new AttackAction(otherActor, location.toString(), this));
        return action;
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
     * get the item
     * @return item
     */
    @Override
    public Item getItem(){
        return new MetalPipe();
    }
}
