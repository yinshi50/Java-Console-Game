package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Gold;

/**
 * The class is an action class specific for the putting pot of gold to wallet.
 */
public class PutGoldToWalletAction extends Action {

    /**
     * The gold object that need to be putted to wallet.
     */
    private Gold gold;

    /**
     * The credits that added to wallet when implementing this action.
     */
    private int addCredits;

    /**
     * constructor
     * @param gold the gold object that added to wallet.
     */
    public PutGoldToWalletAction(Gold gold){
        this.gold = gold;
        this.addCredits = gold.getPutGoldToWalletCredit();
    }

    /**
     * action's execute method.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String indicate that the pot of gold is added to wallet.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addBalance(this.addCredits);
        gold.setAddToWallet();
        return "Successfully put pot of gold to wallet with " + this.addCredits + " credits.";
    }

    /**
     * get the string show in the actions menu.
     * @param actor The actor performing the action.
     * @return string presents the actor's available action.
     */
    @Override
    public String menuDescription(Actor actor){
        return actor + " put pot of gold to wallet.";
    }
}
