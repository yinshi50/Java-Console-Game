package game.inheritree;

import game.items.LargeFruit;

/**
 * Class to represent a Mature Inheritree
 * Created by:
 * @author Woon Chong
 */
public class MatureTree extends Inheritree{
    /**
     * Constructor
     */
    public MatureTree(){
        super('T');
        setFruit(new LargeFruit());
    }

    /**
     * Overloaded constructor
     *
     * @param maturePeriod  Number of ticks before the tree matures
     */
    public MatureTree(int maturePeriod) {
        super('T');
        setFruit(new LargeFruit());
        super.setMaturePeriod(maturePeriod);
    }
}
