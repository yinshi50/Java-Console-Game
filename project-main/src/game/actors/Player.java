package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.behaviour.Status;

import java.util.HashMap;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Chong Woon Kai, Gerard
 * Tong Zhi Enn
 */
public class Player extends Actor implements Traveller {

    private IntrinsicWeapon defaultWeapon;

    private final HashMap<String, GameMap> worldList;
    private final HashMap<GameMap, Location> travelDestination;


    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints, HashMap<String, GameMap> worldList, HashMap<GameMap, Location> travelDestination) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Status.CAN_ENTER_FLOOR);
        this.defaultWeapon = new IntrinsicWeapon(1, "punches", 5);
        this.worldList = worldList;
        this.travelDestination = travelDestination;
        this.addCapability(Ability.TRAVEL);
        this.addCapability(Ability.TELEPORT);

    }



    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return defaultWeapon;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();



        // return/print the console menu
        System.out.println("Intern");
        System.out.println("HP: " +
                this.getAttribute(BaseActorAttributes.HEALTH) + "/" +
                this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        System.out.println("Balance: " + this.getBalance());

        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    @Override
    public HashMap<String, GameMap> getWorldList() {
        return worldList;
    }

    @Override
    public HashMap<GameMap, Location> getTravelDestination() {
        return travelDestination;
    }

}
