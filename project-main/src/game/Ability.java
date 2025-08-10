package game;

/**
 * Use this enum to represent abilities.
 * Example #1: if the player is capable jumping over walls, you can attach Ability.WALL_JUMP to the player class
 */
public enum Ability {
    /**
     * Actors that have the ability to pick up items
     */
    PICK_UP,
    /**
     * Actors that have the ability to travel to different moons
     */
    TRAVEL,
    /**
     * Actors that have the ability to teleport with an item
     */
    TELEPORT
}
