package game.items;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.function.Predicate;

/**
 * Represents a monologue with a specific message and a condition under which it is available.
 * A monologue can be provided to an actor if the specified condition is met.
 *
 * Created by:
 * @author Amadea Theola Benedicta
 */
public class Monologue {
    private String message;
    private Predicate<Actor> condition;

    /**
     * Constructs a Monologue with a specified message and condition.
     *
     * @param message   the message of the monologue
     * @param condition the condition that determines whether the monologue is available for an actor
     */
    public Monologue(String message, Predicate<Actor> condition){
        this.message = message;
        this.condition = condition;
    }

    /**
     * Checks if the monologue is available for the given actor based on the condition.
     *
     * @param actor the actor for whom the availability of the monologue is being checked
     * @return true if the monologue is available for the actor, false otherwise
     */
    public boolean isAvailable(Actor actor){
        return condition.test(actor);
    }

    /**
     * Gets the message of the monologue.
     *
     * @return the message of the monologue
     */
    public String getMessage(){
        return message;
    }
}
