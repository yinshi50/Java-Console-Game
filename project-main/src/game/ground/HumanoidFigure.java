package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.items.ItemCapability;
import game.items.Sellables;

/**
 * This is the humanoid figure that extends ground because it can not be attacked by the player.
 */
public class HumanoidFigure extends Ground {

    /**
     * This is the constructor.
     */
    public HumanoidFigure(){
        super('H');
    }

    /**
     * get allowable actions
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return the items that can be sold to the humanoidFigure
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = super.allowableActions(actor, location, direction);
        for (Item item: actor.getItemInventory()){
            if (item.hasCapability(ItemCapability.CAN_BE_SOLD)){
                actions.add(new SellAction((Sellables) item));
            }
        }
        return actions;
    }

    /**
     * override whether the actor can enter ground
     * @param actor the Actor to check
     * @return boolean
     */
    @Override
    public boolean canActorEnter(Actor actor){
        return false;
    }

    /**
     * override whether the ground can block the objects
     * @return boolean
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
