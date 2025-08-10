package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.behaviour.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Chong Woon Kai, Gerard
 */
public class Floor extends Ground {
    /**
     * Constructor
     */
    public Floor() {
        super('_');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.CAN_ENTER_FLOOR);
    }
}
