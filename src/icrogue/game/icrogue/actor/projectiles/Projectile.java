package icrogue.game.icrogue.actor.projectiles;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.*;
import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.game.icrogue.ICRogueBehavior;
import icrogue.game.icrogue.actor.ICRogueActor;
import icrogue.game.icrogue.actor.enemies.Enemy;
import icrogue.game.icrogue.actor.items.Weapon;
import icrogue.game.icrogue.handler.ICRogueInteractionHandler;
import icrogue.math.DiscreteCoordinates;

public abstract class Projectile extends ICRogueActor implements Consumable, Interactor {
    private int damage;
    private int moveDuration;
    private final static int DEFAULT_DAMAGE = 1;
    private final static int DEFAULT_MOVE_DURATION = 10;
    private boolean isConsumed;

    /**
     * Constructor of Projectile with specific damage and moveDuration.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     * @param damage the damage the projectile will do.
     * @param moveDuration how fast the projectile will go.
     */


    public Projectile(Area area, Orientation orientation, DiscreteCoordinates position, int damage, int moveDuration) {
        super(area, orientation, position);
        this.damage = damage;
        this.moveDuration = moveDuration;
        setInteractionHandler(new ProjectileHandler());

    }

    /**
     * Constructor of Projectile with default damage and moveDuration.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public Projectile(Area area, Orientation orientation, DiscreteCoordinates position) {
        this(area, orientation, position, DEFAULT_DAMAGE, DEFAULT_MOVE_DURATION);
    }

    @Override
    public void update(float deltaTime) {
        //makes the projectile move
        move(moveDuration);
        super.update(deltaTime);
    }

    @Override
    public void consume() {
        // removes the projectile from the area if it is not already consumed
        if (!isConsumed) {
            isConsumed = getOwnerArea().unregisterActor(this);
        }
    }
    @Override
    public boolean isConsumed() {
        return isConsumed;
    }

    //--------------------------Projectile interactions--------------

    /**
     * this interaction handler sets the default interactions of projectiles.
     */
    protected class ProjectileHandler extends ICRogueActorInteractionHandler{
        public void interactWith(ICRogueBehavior.ICRogueCell Cell, boolean wantsViewInteraction){
            //Interaction between a projectile and a cell, consumes the projectile if the cell is a wall or hole.
            if(Cell.getType() == ICRogueBehavior.ICRogueCellType.WALL ||  Cell.getType() == ICRogueBehavior.ICRogueCellType.HOLE ){
                consume();
            }
        }
        @Override
        public void interactWith(Weapon weapon, boolean wantsViewInteraction){
            //Interaction between a projectile and a weapon: consumes the projectile.
            consume();
        }

        @Override
        public void interactWith(Enemy enemy, boolean wantsViewInteraction){
            //Interaction between a projectile and an enemy: damages the enemy, consumes the projectile.
            enemy.damageEnemy(damage);
            consume();
        }
    }

    @Override
    public boolean wantsCellInteraction() {
        return true;
    }

    @Override
    public boolean wantsViewInteraction() {
        return true;
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {
        ((ICRogueInteractionHandler) v).interactWith(this , isCellInteraction);
    }

}
