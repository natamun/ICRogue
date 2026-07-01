package icrogue.game.icrogue.handler;

import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.game.icrogue.ICRogueBehavior;
import icrogue.game.icrogue.actor.Connector;
import icrogue.game.icrogue.actor.ICRoguePlayer;
import icrogue.game.icrogue.actor.enemies.DarkLord;
import icrogue.game.icrogue.actor.enemies.Enemy;
import icrogue.game.icrogue.actor.enemies.Turret;
import icrogue.game.icrogue.actor.friendlyNPC.NinjaPNJ;
import icrogue.game.icrogue.actor.items.*;
import icrogue.game.icrogue.actor.projectiles.Arrow;
import icrogue.game.icrogue.actor.projectiles.FireBall;

import icrogue.game.icrogue.actor.projectiles.Projectile;
import icrogue.game.icrogue.actor.projectiles.WaterBall;

public interface ICRogueInteractionHandler extends AreaInteractionVisitor {
    /**
     * defines the default interaction with a player
     * @param icRoguePlayer
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(ICRoguePlayer icRoguePlayer, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a cell
     * @param Cell
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(ICRogueBehavior.ICRogueCell Cell, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a DarkLord
     * @param DarkLord
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(DarkLord DarkLord, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a turret
     * @param turret
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Turret turret, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a enemy
     * @param enemy
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Enemy enemy, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a weapon
     * @param weapon
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Weapon weapon, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a cherry
     * @param cherry
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Cherry cherry, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a cherry
     * @param heart
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Heart heart, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a key
     * @param key
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Key key, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a Connector
     * @param Connector
     * @param isCellInteraction (boolean)
     */
    default void interactWith(Connector Connector, boolean isCellInteraction){}
    /**
     * defines the default interaction with a projectile
     * @param projectile
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Projectile projectile, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a FireBall
     * @param FireBall
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(FireBall FireBall, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a WaterBall
     * @param WaterBall
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(WaterBall WaterBall, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with a NinjaPNJ
     * @param NinjaPNJ
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(NinjaPNJ NinjaPNJ, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with an Arrow
     * @param Arrow
     * @param wantsViewInteraction (boolean)
     */
    default void interactWith(Arrow Arrow, boolean wantsViewInteraction){}
    /**
     * defines the default interaction with an ICRogueCell
     * @param ICRogueCell
     * @param isCellInteraction (boolean)
     */
    default void interactWith(ICRogueBehavior ICRogueCell, boolean isCellInteraction){}

}
