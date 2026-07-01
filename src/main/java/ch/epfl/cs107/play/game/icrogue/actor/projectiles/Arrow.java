package ch.epfl.cs107.play.game.icrogue.actor.projectiles;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.icrogue.actor.ICRoguePlayer;
import ch.epfl.cs107.play.game.icrogue.actor.enemies.Enemy;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.math.Vector;

public class Arrow extends Projectile {
    private final static int ARROW_DAMAGE = 1;
    private final static int ARROW_MOVE_DURATION = 3;

    /**
     * Creates an instance of an Arrow.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */

    public Arrow(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position, ARROW_DAMAGE, ARROW_MOVE_DURATION);
        setInteractionHandler(new ArrowHandler());

        setSprite(new Sprite("zelda/arrow", 1f, 1f, this,
                new RegionOfInterest(32 * orientation.ordinal(), 0, 32, 32),
                new Vector(0, 0)));
    }

    //--------------------------Arrow interactions-------------------

    private class ArrowHandler extends ProjectileHandler {
        @Override
        public void interactWith(ICRoguePlayer icRoguePlayer, boolean wantsViewInteraction){
            //Interaction between an arrow and the player, damages the player and consumes the arrow.
            ICRoguePlayer.damagePlayer(ARROW_DAMAGE);
            consume();
        }

        @Override
        public void interactWith(Enemy enemy, boolean wantsViewInteraction){
            //Interaction between an arrow and an enemy: consumes the arrow.
            consume();
        }
    }
}
