package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

import java.util.Random;

/**
 * Class to represent DragonSlayerSword
 */
public class DragonSlayerSword extends WeaponItem implements Purchasable{

    /**
     * Price of DragonSlayerSword
     */
    int price = 100;

    /**
     * Chance of rare occurrence to happen
     */
    int rareChance = 50;

    /**
     * Randomizer
     */
    Random r = new Random();

    /***
     * Constructor.
     */
    public DragonSlayerSword() {
        super("dragon slayer sword", 'x', 50, "slashes", 75);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList action = super.allowableActions(otherActor, location);
        action.add(new AttackAction(otherActor, location.toString(), this));
        return action;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getOriginalPrice() {
        return price;
    }

    @Override
    public Item getItem() {
        if (1 + r.nextInt(100) < rareChance) {
            return null;
        }
        return new DragonSlayerSword();
    }
}
