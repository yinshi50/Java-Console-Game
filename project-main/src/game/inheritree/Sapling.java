package game.inheritree;

import game.items.SmallFruit;

/**
 * Class to represent a Sapling Inheritree
 * Created by:
 * @author Woon Chong
 */
public class Sapling extends Inheritree{
    /**
     * Constructor
     */
    public Sapling(){
        super('t');
        setFruit(new SmallFruit());
    }

    /**
     * Overloaded constructor
     *
     * @param maturePeriod  Number of ticks before the tree matures
     */
    public Sapling(int maturePeriod) {
        super('t');
        setFruit(new SmallFruit());
        super.setMaturePeriod(maturePeriod);
    }
}
