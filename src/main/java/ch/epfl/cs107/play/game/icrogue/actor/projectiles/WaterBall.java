package ch.epfl.cs107.play.game.icrogue.actor.projectiles;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.*;
import ch.epfl.cs107.play.game.icrogue.actor.enemies.Enemy;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;

/*
 * Author :     Natalino MUNARI
 * Date :       14.12.2022{
 */
public class WaterBall extends Projectile {
    private final static int WATERBALL_DAMAGE = 3;
    private final static int WATERBALL_MOVE_DURATION = 3;

    /**
     * Creates an instance of a Waterball.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */

    public WaterBall(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position, WATERBALL_DAMAGE, WATERBALL_MOVE_DURATION);

        Vector anchor = new Vector(0,.15f);
        Sprite[] waterBalls = Sprite.extractSprites("zelda/magicWaterProjectile",4, 1f, 1f, this ,anchor,32,32);
        setAnimation(new Animation(2, waterBalls));
    }
}
