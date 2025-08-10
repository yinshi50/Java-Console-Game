package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ListenAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents Astley, an AI Device that can be purchased and provides monologues to the actor.
 * Astley charges a subscription fee every 5 ticks when in the actor's inventory.
 *
 * Created by:
 * @author Amadea Theola Benedicta
 */
public class Astley extends Item implements Purchasable, MonologueProvider {

    private final int SUBSCRIPTION_FEE = 1;

    private final int ORIGINAL_PRICE = 50;

    private int subscription = 0;
    private boolean subscribed = false;

    private final Random random = new Random();

    private List<Monologue> monologues;

    /**
     * Constructor.
     * Initializes the Astley AI device with a name, display character, and portable status.
     */
    public Astley() {
        super("Astley, an AI Device", 'z', true);
    }

    /**
     * Handles the subscription logic for the AI device.
     * Deducts a subscription fee every 5 ticks if the actor has sufficient balance.
     *
     * @param currentLocation The current location of the actor
     * @param actor The actor holding the AI device
     */
    @Override
    public void tick(Location currentLocation, Actor actor){
        if (actor.getItemInventory().contains(this)) {
            subscription++;
            if (subscription == 1){
                this.subscribed = true;
            }
            if (actor.getBalance() >= 1) {
                if (subscription % 5 == 0) {
                    actor.deductBalance(SUBSCRIPTION_FEE);
                    System.out.println("Subscription payment received");
                }
                this.subscribed = true;
            }
            else {
                this.subscribed = false;
            }
        }

    }


    /**
     * Returns the price of item after any discounts or modifications
     *
     * @return New price of item
     */
    @Override
    public int getPrice() {
        return ORIGINAL_PRICE;
    }

    /**
     * Returns the original price of object before any discounts or modifications
     *
     * @return Original price of item
     */
    @Override
    public int getOriginalPrice() {
        return ORIGINAL_PRICE;
    }

    /**
     * Returns the Item that is linked to the Purchasable
     *
     * @return Item purchased
     */
    @Override
    public Item getItem() {
        return new Astley();
    }

    /**
     * Initializes the list of monologues that Astley can provide.
     * This method sets up various monologues with different conditions based on the actor's state.
     */
    @Override
    public void initializeMonologues() {
        monologues.add(new Monologue("The factory will never gonna give you up, valuable intern!", actor -> true));
        monologues.add(new Monologue("We promise we never gonna let you down with a range of staff benefits.", actor -> true));
        monologues.add(new Monologue("We never gonna run around and desert you, dear intern!", actor -> true));
        monologues.add(new Monologue("We never gonna make you cry with unfair compensation.", actor -> (actor.getItemInventory()).size() > 10));
        monologues.add(new Monologue("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.", actor -> actor.getBalance() > 50));
        monologues.add(new Monologue("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.", actor -> actor.getAttribute(BaseActorAttributes.HEALTH) < 2));
    }

    /**
     * Returns a monologue based on the given actor's state.
     * Selects a monologue that is available for the actor from the initialized list.
     *
     * @param actor The actor for whom the monologue is generated
     * @return A string representing the monologue for the actor
     */
    @Override
    public String getMonologue(Actor actor){
        Random rand = new Random();
        List<Monologue> availableMonologues = new ArrayList<>();
        for (Monologue monologue : monologues) {
            if (monologue.isAvailable(actor)) {
                availableMonologues.add(monologue);
            }
        }
        if (availableMonologues.isEmpty()) {
            return "No monologue available.";
        }
        return availableMonologues.get(rand.nextInt(availableMonologues.size())).getMessage();
    }

    /**
     * Returns the list of actions that can be performed on this item by the owner.
     * If the AI device is subscribed, adds the ListenAction to the list of actions.
     *
     * @param owner The actor who owns this item
     * @return The list of allowable actions
     */

    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = super.allowableActions(owner);
        if (this.subscribed) {
            monologues = new ArrayList<>();
            actions.add(new ListenAction(this));
        }
        return actions;
    }

}
