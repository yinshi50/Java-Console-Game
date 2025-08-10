package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Traveller;

import java.util.Random;

/**
 * Class represents TravelAction
 * This class let the actor travel to different moon
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 *
 */
public class TravelAction extends Action {

    Random r = new Random();

    /**
     * The actor to travel
     */
    private Traveller traveller;

    /**
     * The actor's current location
     */
    private Location actorLocation;

    /**
     * The actor's current map
     */
    private GameMap actorMap;

    /**
     * The destination where the traveller decides to go
     */
    private Location destination;

    /**
     * Name of the travel destination
     */
    private String destinationName;


    /**
     * Constructor of TravelAction class
     *
     * @param traveller The actor to travel
     * @param actorLocation The actor's current location
     * @param actorMap The actor's current map
     * @param destination Location of the destination
     * @param destinationName Name of the travel destination
     */
    public TravelAction(Traveller traveller, Location actorLocation, GameMap actorMap, Location destination, String destinationName) {
        this.traveller = traveller;
        this.actorLocation = actorLocation;
        this.actorMap = actorMap;
        this.destination = destination;
        this.destinationName = destinationName;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return this.traveller.travel(actor, actorLocation,actorMap,destination,destinationName);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + this.destinationName;
    }
}
