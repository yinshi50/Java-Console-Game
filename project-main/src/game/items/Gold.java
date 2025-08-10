package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.PutGoldToWalletAction;

import java.util.Random;

/**
 * Class to represent a Bag of Gold
 */
public class Gold extends Item implements Sellables {

    /**
     * the original sell credits
     */
    int sellCredits = 500;

    /**
     * the premium credits
     */
    int premiumCredits = 0;

    /**
     * the chance getting a premium price
     */
    int premiumRate = 25;

    /**
     * the credits player get by simply put the pot of gold to wallet
     */
    int putGoldToWalletCredit = 10;

    Random r = new Random();

    /**
     * define whether the pot of gold is already added to the wallet.
     */
    boolean addToWallet = false;
    /**
     * Constructor
     */
    public Gold(){
        super("Gold", '$', true);
        this.addCapability(ItemCapability.CAN_BE_SOLD);
    }

    /**
     * Return the new gold object
     * @return the item itself
     */
    @Override
    public Item getItem(){
        return new Gold();
    }

    /**
     * get the actual sell credits when being sold.
     * @return actual sell credits
     */
    @Override
    public int getSellCredits(){
        if (1 + r.nextInt(100) < this.premiumRate){
            return this.premiumCredits;
        }else{
            return this.sellCredits;
        }
    }

    /**
     * get the original sell credits
     * @return original sell credits
     */
    @Override
    public int getOriginalSellCredits(){
        return this.sellCredits;
    }

    /**
     * get the credits added to the player's wallet when putting the pot of gold to the player's wallet
     * @return the credits
     */
    public int getPutGoldToWalletCredit(){
        return this.putGoldToWalletCredit;
    }

    /**
     * set the pot of gold to be added to wallet already
     */
    public void setAddToWallet(){
        this.addToWallet = true;
    }

    /**
     * get the allowable actions for this gold when haven't been added to the wallet yet.
     * @param actor the actor that owns the item
     * @return list of allow actions
     */
    @Override
    public ActionList allowableActions(Actor actor){
        ActionList newActionList = new ActionList();
        if (!this.addToWallet){
            newActionList.add(new PutGoldToWalletAction(this));  // can not use the new gold() do not create new gold()
        }
        return newActionList;
    }
}
