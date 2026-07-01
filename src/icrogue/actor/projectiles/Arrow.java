package icrogue.game.icrogue.actor.projectiles;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.areagame.actor.Sprite;
import icrogue.game.icrogue.actor.ICRoguePlayer;
import icrogue.game.icrogue.actor.enemies.Enemy;
import icrogue.math.DiscreteCoordinates;
import icrogue.math.RegionOfInterest;
import icrogue.math.Vector;

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
