package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.BuyAction;
import game.actions.TravelAction;
import game.actors.Traveller;
import game.items.*;

/**
 * Class to represent a ComputerTerminal
 */
public class ComputerTerminal extends Ground {
    /**
     * Constructor.
     */
    public ComputerTerminal() {
        super('=');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        actions.add(new BuyAction(new EnergyDrink()));
        actions.add(new BuyAction(new DragonSlayerSword()));
        actions.add(new BuyAction(new ToiletPaperRoll()));
        actions.add(new BuyAction(new Theseus()));
        actions.add(new BuyAction(new Astley()));

        if(actor.hasCapability(Ability.TRAVEL)){
            Traveller travellerActor = (Traveller) actor; // upcast the actor
            for (String mapName : travellerActor.getWorldList().keySet()) { // iterate through worldList to obtain mapName
                // if the actor is not on certain map, they can travel to the other map that they're not currently on
                if(!travellerActor.getWorldList().get(mapName).contains(actor)){
                    GameMap gameMap = travellerActor.getWorldList().get(mapName); // obtain the list of available game maps

                    actions.add(new TravelAction(travellerActor, location, gameMap,
                            travellerActor.getTravelDestination().get(gameMap), mapName));
                }
            }
        }

        return actions;
    }
}
