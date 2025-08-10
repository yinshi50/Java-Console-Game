package game.ground;

import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;

/**
 * Class to represent Puddle
 */
public class Puddle extends SpecialGround {
    /**
     * Constructor
     */
    public Puddle() {
        super('~', "Puddle", BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 1);
    }


}
