package game.ground;

import game.inheritree.MatureTree;
import game.inheritree.Sapling;

/**
 * Class to represent a Tree Ground in Polymorphia map
 * Created by:
 * @author Woon Chong
 */
public class PolymorphiaTree extends Tree{
    /**
     * Constructor
     */
    public PolymorphiaTree() {
        super('.');
        treeType = new Sapling(5);
        addTreeStage(new MatureTree());
        setDisplayChar(treeType.getDisplayChar());
        setNextTreeStage(treeGrowth.get(count));
        count++;
    }
}
