package game.inheritree;

/**
 * Class to represent a Sprout Inheritree
 * Created by:
 * @author Woon Chong
 */
public class Sprout extends Inheritree{
    /**
     * Constructor
     */
    public Sprout() {
        super(',');
    }

    /**
     * Overloaded constructor
     *
     * @param maturePeriod  Number of ticks before the tree matures
     */
    public Sprout(int maturePeriod) {
        super(',');
        super.setMaturePeriod(maturePeriod);
    }
}
