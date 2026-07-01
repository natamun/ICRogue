package icrogue.game.icrogue.actor.projectiles;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.*;
import icrogue.game.icrogue.actor.enemies.Enemy;
import icrogue.game.icrogue.actor.enemies.FlameSkull;
import icrogue.game.icrogue.actor.enemies.Turret;
import icrogue.game.icrogue.handler.ICRogueInteractionHandler;
import icrogue.math.DiscreteCoordinates;
import icrogue.math.Vector;

/*
 * Author :     Natalino MUNARI
 * Date :       03.12.2022{
 */
public class FireBall extends Projectile {
    private final static int FIREBALL_DAMAGE = 3;
    private final static int FIREBALL_MOVE_DURATION = 3;

    /**
     * Creates an instance of a FireBall.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */

    public FireBall(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position,FIREBALL_DAMAGE, FIREBALL_MOVE_DURATION);
        setInteractionHandler(new FireBallHandler());

        Vector anchor = new Vector(0,.15f);
        Sprite [] fireBalls = Sprite.extractSprites("zelda/fire",6, 1f, 1f, this ,anchor,16,16);
        setAnimation(new Animation(2, fireBalls));
    }

    //--------------------------FireBall interactions----------------

    private class FireBallHandler extends ProjectileHandler {
        @Override
        public void interactWith(Enemy enemy, boolean wantsViewInteraction){
            //Interaction between a fireball and an enemy: consumes the fireball and damages  the enemy if it is not a FlameSkull.
            if(enemy.getClass() != FlameSkull.class){
                enemy.damageEnemy(FIREBALL_DAMAGE);
            }
            consume();
        }
    }
}
