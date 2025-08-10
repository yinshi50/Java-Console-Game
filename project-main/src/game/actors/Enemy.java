package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Enemy abstract class to represent an enemy actor
 */
public abstract class Enemy extends Actor {

    private int spawnChance;

    /**
     * The constructor of the Actor class.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param spawnChance the chance for the enemy to spawn into the game
     */
    public Enemy(String name, char displayChar, int hitPoints, int spawnChance) {
        super(name, displayChar, hitPoints);
        this.spawnChance = spawnChance;
    }

    /**
     * Method to create a new Enemy object
     * @return              new Enemy object
     */
    public Enemy createEnemy() {
        return null;
    }

    /**
     * Method to return enemy's spawn chance
     * @return              Enemy's spawn chance
     */
    public int getSpawnChance(){
        return spawnChance;
    }
}
