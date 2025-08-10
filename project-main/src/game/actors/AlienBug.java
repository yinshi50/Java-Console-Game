package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.AttackAction;
import game.behaviour.FollowBehaviour;
import game.behaviour.PickUpBehaviour;
import game.behaviour.Status;
import game.behaviour.WanderBehaviour;

import java.util.*;

/**
 * Class representing Alien Bug, living creature on the moon
 * capable of stealing scraps on the moon
 *
 * Inherits from Enemy class
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 */
public class AlienBug extends Enemy {

    /**
     * The spawn probability of Alien Bug
     */
    private static final int ALIEN_BUG_SPAWN_PROBABILITY = 10;

    /**
     * A map that stores behaviours associated with their corresponding priorities
     * The keys represent priorities, and the values represent the behaviours
     */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor of the class
     *
     * Alien Bug appears as 'a' on the map, has 2 hit point (health), and has a spawn rate of 10%
     * Has capabilities of picking up scraps and entering spaceship
     */
    public AlienBug() {
        super("Feature-" + generateAlienBugID(), 'a', 2, ALIEN_BUG_SPAWN_PROBABILITY);
        this.behaviours.put(999, new WanderBehaviour()); // can wander around the map
        this.behaviours.put(1, new PickUpBehaviour()); // can pick up scraps, will pick up scrap first and continue follow intern
        this.addCapability(Ability.PICK_UP);         // alien bug has ability to pick up scraps
        this.addCapability(Status.CAN_ENTER_FLOOR); // alien bug can enter spaceship

    }

    /**
     * A random number generator
     * @return a random integer between 0 and 999
     */
    public static int generateRandomInt() {  // number generator
        Random random = new Random();
        return random.nextInt(1000);
    }

    /**
     * A random number generator for Alien Bug's ID such as "Feature-XXX" where XXX represents the 3 digits
     * @return random 3 digits
     */
    public static String generateAlienBugID(){  // alien bug ID generator
        int randomGeneratedDigit = generateRandomInt();
        String randomDigit = String.format("%03d",randomGeneratedDigit); // generates 3 digits
        return randomDigit;
    }

    /**
     *
     * @return new Alien Bug object
     */
    @Override
    public Enemy createEnemy() {
        return new AlienBug();
    }

    /**
     * At each turn, Alien Bug will have option to perform action
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if(this.isConscious()) {
            // alien bug will prioritise picking up scraps first
            for (Behaviour behaviour : behaviours.values()) {  // prioritises behaviour with smaller value
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * The Alien Bug can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions that can be performed to this Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        boolean inRange = false; // updates the enemy if it is in range around player

        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){  // other actor(e.g. player) can attack alien bug
            actions.add(new AttackAction(this, direction));
            inRange = true;
        }
        if(inRange) { // true
            this.behaviours.put(2, new FollowBehaviour(otherActor)); // alien bug will follow other actor(e.g. player)
        }
        return actions;
    }


}
