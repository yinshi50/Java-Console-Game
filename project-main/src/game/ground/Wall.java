package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Chong Woon Kai, Gerard
 */
public class Wall extends Ground {

    /**
     * Constructor
     */
    public Wall() {
        super('#');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
