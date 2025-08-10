package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing a behaviour of following a target
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 */
public class FollowBehaviour implements Behaviour {

    /**
     * Attacker's target
     */
    private Actor target; // the target that the actor will follow

    /**
     * Constructor of FollowBehaviour class
     * @param target The target to be attacked
     */
    public FollowBehaviour(Actor target) {
        this.target = target;
    }

    /**
     * Returns a movement to follow target
     * If no movement is possible, returns null
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an Action, or null if no movement is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(!map.contains(target) || !map.contains(actor))
            return null;

        // obtain the location of the actor and the target
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int currentDistance = distance(here, there); // get the manhattan distance between actor and the target
        for (Exit exit : here.getExits()) {  // Exit is a route from one Location to another, here we loop through location of actor
            Location destination = exit.getDestination(); // obtain destination
            if (destination.canActorEnter(actor)) {  // if actor can enter destination
                int newDistance = distance(destination, there); // update the new manhattan distance
                if (newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName()); // actor will move to the destination and follow the direction where the target is
                }
            }
        }

        return null;
    }

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
