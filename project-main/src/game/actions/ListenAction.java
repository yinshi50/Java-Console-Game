package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.MonologueProvider;

/**
 * Represents an action where an actor listens to a monologue from a MonologueProvider.
 *
 * Created by:
 * @author Amadea Theola Benedicta
 */
public class ListenAction extends Action {
    private MonologueProvider speaker;
    private String message;

    /**
     * Constructor.
     * Initializes the ListenAction with a specific MonologueProvider.
     *
     * @param speaker The MonologueProvider that will provide the monologue
     */
    public ListenAction(MonologueProvider speaker){
        this.speaker = speaker;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened (the result of the action being performed) that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        speaker.initializeMonologues();
        message = speaker.getMonologue(actor);
        return "%s: %s".formatted(speaker, message);
    }

    /**
     * Describe what action will be performed if this Action is chosen in the menu.
     *
     * @param actor The actor performing the action.
     * @return the action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Listen to %s".formatted(speaker);
    }
}
