package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Sellables;

import java.util.Random;

/**
 * Class that represents a Sell Action
 */
public class SellAction extends Action {
    /**
     * Item that can add the balance of actor's wallet
     */
    private Sellables item;

    /**
     * The credit the sell item can be sold
     */
    private int sellCredit;

    /**
     * The original credit of the sellable item
     */
    private int originalCredit;

    /**
     * constructor
     * @param sellItem the item can be sold
     */
    public SellAction(Sellables sellItem){
        this.item = sellItem;
        this.sellCredit = sellItem.getSellCredits();
        this.originalCredit = sellItem.getOriginalSellCredits();
    }

    /**
     * execute to sell the sellable object.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the string that indicate the action is done.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Random r = new Random();
        if (1 + r.nextInt(100) < this.item.getKillRate()){
            map.removeActor(actor);
            return actor + " instantly killed when selling " + this.item + " to humanoid figure.";
        }else {
            actor.addBalance(this.sellCredit);
            actor.removeItemFromInventory((Item)this.item);
            return actor + " sold " + this.item + " ($" + this.sellCredit + ")" + " to humanoid figure.";
        }
    }

    /**
     * The string show in the menu
     * @param actor The actor performing the action.
     * @return String show the sellAction details
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + this.item + " to humanoid figure and get $" + this.originalCredit + ".";
    }
}
