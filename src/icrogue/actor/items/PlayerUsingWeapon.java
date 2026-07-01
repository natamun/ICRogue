package icrogue.actor.items;

import icrogue.engine.game.areagame.Area;
import icrogue.engine.game.areagame.actor.Animation;
import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.actor.projectiles.Projectile;
import icrogue.engine.math.DiscreteCoordinates;
import icrogue.engine.math.Positionable;

public interface PlayerUsingWeapon {
    /**
     * We want that all weapon have a projectile & a cool down.
     */
    Projectile getWeaponProjectiles(Area area, Orientation orientation, DiscreteCoordinates cellInFrontOfActor);
    double getWeaponCoolDown();

}
