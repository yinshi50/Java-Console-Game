package game.ground;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actors.Enemy;

import java.util.List;
import java.util.Random;

/**
 * Class to represent a spawner's mechanics
 */
public class Spawner {

    /**
     * Enemy to be spawned
     */
    Enemy spawningEnemy;

    /**
     * Randomizer
     */
    Random random = new Random();

    /**
     * Constructor
     * @param spawningEnemy Enemy that will be spawned from the spawner
     */
    public Spawner(Enemy spawningEnemy) {
        this.spawningEnemy = spawningEnemy;
    }

    /**
     * Method to spawn an enemy from a randomly selected exit from the spawner's location
     * @param location  Location of the spawner
     */
    protected void spawnEnemies(Location location){
        Enemy enemy= spawningEnemy.createEnemy();
        Location destination = Utility.generateSpawnExit(location, enemy);
        if (destination != null && random.nextInt(100) <= enemy.getSpawnChance()) {
            destination.addActor(enemy);
        }
    }
}
