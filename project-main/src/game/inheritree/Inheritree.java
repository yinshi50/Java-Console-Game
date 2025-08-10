package game.inheritree;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.behaviour.Spawnable;

import java.util.Random;

/**
 * Interface for an Inheritree
 * Created by:
 * @author Woon Chong
 */
public abstract class Inheritree extends Ground implements EvolveCapable{
    /**
     * Display char to represent Inheritree
     */
    char displayChar;

    /**
     * Age of tree
     */
    int age;

    /**
     * Fruit that can spawn from Inheritree
     */
    Spawnable fruit;

    /**
     * Randomizer
     */
    Random r = new Random();

    /**
     * The next tree stage the current Inheritree will grow into
     */
    private Inheritree nextTreeStage;

    /**
     * How long it takes before the current Inheritree grows into its next stage
     */
    private int maturePeriod;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Inheritree(char displayChar) {
        super(displayChar);
        this.displayChar = displayChar;
    }

    /**
     * Get the age of the tree
     * @return  Age of tree
     */
    public int getAge(){
        return age;
    }

    /**
     * Set the current age of the tree
     * @param age   Age of tree to be changed to
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * Set the fruit that will drop from the tree
     * @param fruit Fruit that drops from the tree
     */
    public void setFruit(Spawnable fruit) {
        this.fruit = fruit;
    }

    /**
     * Set the maturity period for when the Inheritree will mature
     * @param maturePeriod  Number of ticks before the Inheritree grows
     */
    public void setMaturePeriod(int maturePeriod) {
        this.maturePeriod = maturePeriod;
    }

    /**
     * Method to get the current Inheritree's maturity period
     * @return  Mature period of current Inheritree
     */
    public int getMaturePeriod() {
        return this.maturePeriod;
    }

    /**
     * Method to attempt to grow fruit
     * @param location  Location of Inheritree
     */
    public void growFruit(Location location) {
        setAge(getAge() + 1);
        if (fruit != null) {
            if (1 + r.nextInt(100) <= fruit.getSpawnChance()) {
                Item spawnFruit = fruit.getItem();
                Location destination = Utility.generateDropExit(location);
                destination.addItem(spawnFruit);
            }
        }
    };

    /**
     * Method to check if Inheritree matures to its next growth phase
     * @return          True if Inheritree is matured
     */
    public Inheritree isMatured() {
        if (age == maturePeriod && nextTreeStage != null) {
            nextTreeStage = getNextTreeStage();
            nextTreeStage.setAge(getAge());
            nextTreeStage.setMaturePeriod(nextTreeStage.getMaturePeriod() + getAge());
            return nextTreeStage;
        }
        return null;
    };

    @Override
    public void setNextTreeStage(Inheritree treeStage) {
        this.nextTreeStage = treeStage;
    }

    @Override
    public Inheritree getNextTreeStage() {
        return this.nextTreeStage;
    }
}
