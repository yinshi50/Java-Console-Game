package game.ground;

import game.inheritree.*;

/**
 * Class to represent a Tree Ground in Refactorio map
 * Created by:
 * @author Woon Chong
 */
public class RefactorioTree extends Tree {
    /**
     * Constructor
     */
    public RefactorioTree() {
        super('.');
        treeType = new Sprout(3);
        addTreeStage(new Sapling(6));
        addTreeStage(new YoungTree(5));
        addTreeStage(new MatureTree());
        setDisplayChar(treeType.getDisplayChar());
        setNextTreeStage(treeGrowth.get(count));
        count++;
    }
}
