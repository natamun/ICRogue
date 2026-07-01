package icrogue.actor.projectiles;

public interface Consumable {
    /** Consume the item.
     * Note: Need to be Override
     */
    void consume();

    /** Getter to know if the projectile was consumed.
     * Note: Need to be Override
     * @return (boolean) if the Projectile was consumed.
     */
    boolean isConsumed();
}
