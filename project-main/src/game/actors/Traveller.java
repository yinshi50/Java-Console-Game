package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.HashMap;

/**
 * Interface for actor that can travel between maps
 *
 * Created by:
 * @author Tong Zhi Enn
 * Modified by:
 *
 */
public interface Traveller {

    /**
     * A getter method for the worldList hashMap
     * @return a hashMap containing the names(String) and GameMaps
     */
    HashMap<String, GameMap> getWorldList();

    /**
     * A getter method for the travelDestination hashMap
     * @return a hashMap containing the destination's GameMap and Location
     */
    HashMap<GameMap, Location> getTravelDestination();


    /**
     * This default method moves the actor to desired destination (e.g. different maps: Factory, Polymorphia, etc)
     *
     * @param actor The actor that is travelling
     * @param actorLocation The actor's current location
     * @param actorMap The actor's current map
     * @param destination The actor's destination location
     * @param destinationName Name of the destination
     * @return The detail where the actor has travel to
     */
    default String travel(Actor actor, Location actorLocation, GameMap actorMap, Location destination, String destinationName){

        destination.map().moveActor(actor, destination); // move actor to destination

        return actor + " has successfully travelled to "  + destinationName;
    }

}
