package game.inheritree;

/**
 * Class to represent a Young Inheritree
 * Created by:
 * @author Woon Chong
 */
public class YoungTree extends Inheritree {
    /**
     * Constructor
     */
    public YoungTree(){
        super('y');
    }

    /**
     * Overloaded constructor
     *
     * @param maturePeriod  Number of ticks before the tree matures
     */
    public YoungTree(int maturePeriod) {
        super('y');
        super.setMaturePeriod(maturePeriod);
    }
}
