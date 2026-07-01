package icrogue.game.icrogue.actor.items;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Animation;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.icrogue.actor.projectiles.Projectile;
import icrogue.math.DiscreteCoordinates;
import icrogue.math.Positionable;

public interface PlayerUsingWeapon {
    /**
     * We want that all weapon have a projectile & a cool down.
     */
    Projectile getWeaponProjectiles(Area area, Orientation orientation, DiscreteCoordinates cellInFrontOfActor);
    double getWeaponCoolDown();

}
