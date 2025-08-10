package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DrinkAction;

import java.util.Objects;

/**
 * Abstract class that implements Ground that have Special interactions
 */
public abstract class SpecialGround extends Ground {

    /**
     * Base actor's attribute that need to change
     */
    private BaseActorAttributes attributes;

    /**
     * The operations done on the attribute
     */
    private ActorAttributeOperations operations;

    /**
     * The points need to change
     */
    private int changePoints;
    /**
     * the name of the ground
     */
    private String GroundName;

    /**
     * constructor
     * @param displayChar the char to display
     * @param GroundName the name of the Ground
     * @param attributes the base attributes that the
     * @param operations the operations that the actor can do
     * @param changePoints the points that the ground can change
     */
    public SpecialGround(char displayChar, String GroundName, BaseActorAttributes attributes, ActorAttributeOperations operations, int changePoints){
        super(displayChar);
        this.GroundName = GroundName;
        this.attributes = attributes;
        this.operations = operations;
        this.changePoints = changePoints;
    }

    /**
     *
     * @return change points
     */
    public int getChancePoints() {
        return this.changePoints;
    }

    /**
     *
     * @return actor attributes
     */
    public BaseActorAttributes getModifiedAttributes(){
        return this.attributes;
    }

    /**
     *
     * @return operations
     */
    public ActorAttributeOperations getOperations() {
        return this.operations;
    }

    /**
     * @return ground name
     */
    public String getGroundName(){
        return this.GroundName;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = super.allowableActions(actor, location, "");
        if (Objects.equals(direction, "")) {  // only when the actor is on the ground
            actions.add(new DrinkAction(this));
        }
        return actions;
    }
}
