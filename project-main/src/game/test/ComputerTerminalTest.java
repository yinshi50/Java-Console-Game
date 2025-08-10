package game.test;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;

/**
 * Test for ComputerTerminal
 */
public class ComputerTerminalTest {

    /**
     * Adds 10000 credits to Player's wallet
     * @param actor Actor to add balance to
     */
    public ComputerTerminalTest(Player actor) {
        actor.addBalance(10000);
    }
}
