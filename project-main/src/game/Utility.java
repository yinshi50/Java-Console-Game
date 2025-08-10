package game;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Provides utility methods for common game functionalities.
 *<p>
 * This class serves as a helper containing static methods which perform various utility tasks
 * throughout the game, facilitating common operations needed in multiple parts of the game code.
 * </p>
 */
public class Utility {
    static Random random = new Random();

    /**
     * Selects a random exit from the given location and returns the destination of that exit.
     * <p>
     * This method is used to randomly determine a new location from a set of possible exits,
     * which can be useful for random movement or teleportation mechanics within the game. It helps
     * in scenarios where an element or character needs to be moved to a connected location without
     * a fixed pattern, enhancing gameplay unpredictability.
     * </p>
     * <p>
     * @param location The location from which to find and select a random exit.
     * @return The destination location associated with the randomly selected exit. Returns null if
     * there are no exits available from the given location.
     * </p>
     */
    public static Location generateDropExit(Location location){
        List<Exit> exits = location.getExits();
        Exit exit = exits.get(random.nextInt(exits.size()));
        return exit.getDestination();
    }

    /**
     * Generates a valid spawn exit location for an enemy based on its ability to enter available exits.
     * This method selects a random exit from the given location that the enemy can enter.
     * It iterates through the list of exits and removes those that the enemy cannot enter.
     * If there are no accessible exits, the method returns null.
     *
     * @param location The starting location containing potential exits.
     * @param enemy The enemy for which the exit needs to be generated.
     * @return The destination of a random exit that the enemy can enter, or null if no such exit exists.
     */
    public static Location generateSpawnExit(Location location, Enemy enemy){
        List<Exit> exits = new ArrayList<>(location.getExits());
        for (int i = exits.size()-1; i >= 0; i--) {
            Exit exit = exits.get(i);
            if (!(exit.getDestination().canActorEnter(enemy))){
                exits.remove(exit);
            }
        }

        if (!exits.isEmpty()){
            Exit exit = exits.get(random.nextInt(exits.size()));
            return exit.getDestination();
        }
        return null;
    }
}
