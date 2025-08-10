package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.inheritree.Inheritree;

import java.util.ArrayList;

/**
 * Abstract class to represent Trees in the Game Map
 * Created by:
 * @author Woon Chong
 */
public abstract class Tree extends Ground {
    /**
     * The type of tree the Ground is representing
     */
    protected Inheritree treeType;

    /**
     * ArrayList of trees that represents the growth stages
     */
    protected ArrayList<Inheritree> treeGrowth = new ArrayList<>();

    /**
     * Iterator to go through treeGrowth ArrayList
     */
    protected int count = 0;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Tree(char displayChar) {
        super(displayChar);
    }

    /**
     * Set the current tree's next growth stage
     * @param treeStage  Tree that the current tree will grow into
     */
    public void setNextTreeStage(Inheritree treeStage) {
        treeType.setNextTreeStage(treeStage);
    }

    /**
     * Add the tree growth stage into the array list that represents the growth stage of the tree
     * @param treeStage  Tree growth stage
     */
    public void addTreeStage(Inheritree treeStage) {
        treeGrowth.add(treeStage);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        treeType.growFruit(location);
        Inheritree nextTreeStage = treeType.isMatured();
        if (nextTreeStage != null) {
            this.treeType = nextTreeStage;
            setDisplayChar(nextTreeStage.getDisplayChar());
            if (count < treeGrowth.size()) {
                setNextTreeStage(treeGrowth.get(count));
                count++;
            }
        }
    }
}
