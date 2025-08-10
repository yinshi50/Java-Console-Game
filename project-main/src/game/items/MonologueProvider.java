package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for entities that can provide monologues.
 * Classes implementing this interface can initialize and provide monologues
 * based on the state of an actor.
 *
 * Created by:
 * @author Amadea Theola Benedicta
 */
public interface MonologueProvider {

    /**
     * Initializes the list of monologues.
     * This method should be called to set up the initial set of monologues
     * that the implementing class can provide.
     */
    void initializeMonologues();

    /**
     * Gets a monologue based on the given actor's state.
     *
     * @param actor the actor for whom the monologue is generated
     * @return a string representing the monologue for the actor
     */
    String getMonologue(Actor actor);
}
