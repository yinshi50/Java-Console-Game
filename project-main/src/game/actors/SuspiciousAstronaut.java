package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.actions.AttackAction;
import game.behaviour.AttackBehaviour;
import game.behaviour.Status;
import game.behaviour.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing Suspicious Astronaut
 * Extremely dangerous, will instant kill player
 *
 * Inherits from Enemy class
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 *
 */
public class SuspiciousAstronaut extends Enemy {

    /**
     * The spawn probability of Suspicious Astronaut
     */
    private static final int SUSPICIOUS_ASTRONAUT_SPAWN_PROBABILITY = 100;

    /**
     * A map that stores behaviours associated with their corresponding priorities
     * The keys represent priorities, and the values represent the behaviours
     */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Default weapon of the actor
     * @return an intrinsic weapon possessed by the actor
     */
    private IntrinsicWeapon dagger = new IntrinsicWeapon(Integer.MAX_VALUE, "stabs", SUSPICIOUS_ASTRONAUT_SPAWN_PROBABILITY); // instant kills, so damage is the highest possible value

    /**
     * Constructor of the class
     *
     * Suspicious Astronaut appears as 'ඞ' on the map, has 99 hit point (health), and has a spawn rate of 5%
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", '\u0D9E', 99, 5);
        this.behaviours.put(1, new AttackBehaviour(dagger));
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     *
     * @return new SuspiciousAstronaut object
     */
    @Override
    public Enemy createEnemy() {
        return new SuspiciousAstronaut();
    }

    /**
     * At each turn, Suspicious Astronaut will have option to perform action
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The Suspicious Astronaut can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions that can be performed to this Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}
