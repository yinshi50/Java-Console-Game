package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;

/**
 * Class to represent an actor's behaviour for attacking
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Actor to be attacked
     */
    private Actor target;

    /**
     * Weapon used to attack the target
     */
    private Weapon weapon;

    /**
     * Constructor
     *
     * @param weapon        Weapon used by attacker
     */
    public AttackBehaviour(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.map().isAnActorAt(destination) && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                target = destination.getActor();
                return new AttackAction(target, exit.getName(), weapon);
            }
        }
        return null;
    }
}
