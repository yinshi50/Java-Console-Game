package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Ability;

import java.util.List;
import java.util.Random;

/**
 * Class representing a behaviour of picking up scrap
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 */
public class PickUpBehaviour implements Behaviour {

    /**
     * Allows actor to pick up scraps on the floor
     * When there is multiple scraps on the floor, actor will randomly take a single scrap
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return null if nothing can be picked up
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        List<Item> items = map.locationOf(actor).getItems(); // list of items on actor's location

        // if floor has more than 1 scrap, randomly pick 1
        if (actor.hasCapability(Ability.PICK_UP) && !items.isEmpty()) {  // if actor has the ability to pick up items

            Random random = new Random();
            int randIndex = random.nextInt(items.size());
            return new PickUpAction(items.get(randIndex));  // allow the actor to randomly pick up the item when there is multiple scrap on the floor

        }

        return null;

    }


}
