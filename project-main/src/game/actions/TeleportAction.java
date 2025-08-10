package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Traveller;

import java.util.HashMap;
import java.util.Random;

/**
 * Class that represents TeleportAction
 *
 * This class teleports / move the actor to a random location
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 *
 */
public class TeleportAction extends Action {

    /**
     * The actor to teleport
     */
    private Actor actor;

    /**
     * The location on actor
     */
    private Location location;

    /**
     * The item that handles the teleportation
     */
    private Item item;
    Random r = new Random();

    /**
     * Constructor of TeleportAction class
     *
     * @param actor The actor to teleport
     * @param location The destination where the actor will be teleported to
     * @param item The item that handles the teleportation
     *
     */
    public TeleportAction(Actor actor, Location location, Item item) {
        this.actor = actor;
        this.location = location;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        // obtain the maximum range of the map of x and y
        int boundaryX = map.getXRange().max();
        int boundaryY = map.getYRange().max();

        // generate random coordinates base on the obtained range
        int randomCoorX = r.nextInt(boundaryX);
        int randomCoorY = r.nextInt(boundaryY);

        String retStr;
        // check if there is another actor on the random generated location
        if(map.isAnActorAt(map.at(randomCoorX, randomCoorY))){ // true
            retStr = "Teleportation fail, destination contains living entity" + "\n" + "Please try again.";
        } else {
            map.moveActor(actor, map.at(randomCoorX, randomCoorY)); // false
            retStr = actor + " teleported to " + map.locationOf(actor) + " in current map";
        }

        return retStr;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports with " + this.item;
    }
}
