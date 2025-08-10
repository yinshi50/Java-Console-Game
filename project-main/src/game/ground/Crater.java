package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Enemy;

/**
 * Class to represent a Crater ground
 */
public class Crater extends Ground {

    Spawner spawner;

    /**
     * Constructor
     * @param spawningEnemy     Enemy that will spawn from the Crater
     */
    public Crater(Enemy spawningEnemy) {
        super('u');
        this.spawner = new Spawner(spawningEnemy);
    }

    @Override
    public void tick(Location location) {
        spawner.spawnEnemies(location);
    }
}
