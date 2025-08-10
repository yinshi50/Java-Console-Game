package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ground.SpecialGround;

/**
 * Class to represent a Drink Action from Ground
 */
public class DrinkAction extends Action {

    /**
     * Base actor's attribute that need to change
     */
    private final BaseActorAttributes attributes;
    /**
     * The operations done on the attribute
     */
    private final ActorAttributeOperations operations;
    /**
     * The points need to change
     */
    private final int changePoints;
    /**
     * The special ground that changed
     */
    private final SpecialGround ground;

    /**
     *
     * @param ground the special ground actor interact with
     */
    public DrinkAction(SpecialGround ground){
        this.ground = ground;
        this.changePoints = ground.getChancePoints();
        this.attributes = ground.getModifiedAttributes();
        this.operations = ground.getOperations();
    }


    /**
     * Executes the action of an actor drinking from the specified ground. This modifies the actor's
     * attributes based on the specified operations and change points.
     *
     * @param actor The actor performing the action.
     * @param map   The game map where the action takes place.
     * @return A description of the action performed.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.modifyAttributeMaximum(this.attributes, this.operations, this.changePoints);
        return actor + " drinks " + this.ground.getGroundName() + " and " + this.operations + " " + this.attributes + " by " + this.changePoints;
    }

    /**
     * Provides a description of the action to be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return A description of the action for the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks " + this.ground.getGroundName();
    }
}
