package game.test;

import edu.monash.fit2099.engine.positions.GameMap;
import game.Application;
import game.actors.HuntsmanSpider;
import game.ground.Wall;

/**
 * Class to run tests for requirement 3 in A1
 */
public class HuntsmanSpiderTest {

    /**
     * Map of the game
     */
    private GameMap gameMap;

    /**
     * Constructor
     * @param map       Map for the game
     */
    public HuntsmanSpiderTest(GameMap map) {
        this.gameMap = map;
    }

    /**
     * Test to check if HuntsmanSpider will wander onto the spaceship's floor
     */
    public void spiderSpaceshipFloorTest() {
        gameMap.at(15, 8).addActor(new HuntsmanSpider());
        gameMap.at(14,8).setGround(new Wall());
        gameMap.at(16,8).setGround(new Wall());
        gameMap.at(14,9).setGround(new Wall());
        gameMap.at(15,9).setGround(new Wall());
        gameMap.at(16,9).setGround(new Wall());
    }

    /**
     * Test to check if HuntsmanSpider will attack other HuntsmanSpider
     */
    public void spiderAttackSpiderTest() {
        gameMap.at(7, 8).addActor(new HuntsmanSpider());
    }

    /**
     * Test to check if crater will stop spawning HuntsmanSpider
     * when all exits have actors and not crash the game
     */
    public void craterExitFullTest() {
        gameMap.at(23, 9).setGround(new Wall());
        gameMap.at(24, 9).setGround(new Wall());
        gameMap.at(25, 9).setGround(new Wall());
        gameMap.at(26, 9).setGround(new Wall());
        gameMap.at(27, 9).setGround(new Wall());
        gameMap.at(23, 10).setGround(new Wall());
        gameMap.at(27, 10).setGround(new Wall());
        gameMap.at(23 , 11).setGround(new Wall());
        gameMap.at(27, 11).setGround(new Wall());
        gameMap.at(23 , 12).setGround(new Wall());
        gameMap.at(27, 12).setGround(new Wall());
        gameMap.at(23, 13).setGround(new Wall());
        gameMap.at(24, 13).setGround(new Wall());
        gameMap.at(25, 13).setGround(new Wall());
        gameMap.at(26, 13).setGround(new Wall());
        gameMap.at(27, 13).setGround(new Wall());
        gameMap.at(24, 10).addActor(new HuntsmanSpider());
        gameMap.at(25, 10).addActor(new HuntsmanSpider());
        gameMap.at(26, 10).addActor(new HuntsmanSpider());
        gameMap.at(24, 11).addActor(new HuntsmanSpider());
        gameMap.at(25, 11).addActor(new HuntsmanSpider());
        gameMap.at(26, 11).addActor(new HuntsmanSpider());
        gameMap.at(24, 12).addActor(new HuntsmanSpider());
        gameMap.at(25, 12).addActor(new HuntsmanSpider());
        gameMap.at(26, 12).addActor(new HuntsmanSpider());
    }
}
