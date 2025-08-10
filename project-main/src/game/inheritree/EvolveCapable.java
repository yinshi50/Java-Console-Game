package game.inheritree;

/**
 * Interface for objects that are able to evolve
 * Created by:
 * @author Woon Chong
 */
public interface EvolveCapable {
    /**
     * Method to set the next growth phase for the current Inheritree
     * @param treeStage  Type of tree stage the current Inheritree will grow into
     */
    void setNextTreeStage(Inheritree treeStage);

    /**
     * Method to get the next growth phase the current Inheritree will grow into
     * @return  Type of tree stage the current Inheritree will grow into
     */
    Inheritree getNextTreeStage();
}
