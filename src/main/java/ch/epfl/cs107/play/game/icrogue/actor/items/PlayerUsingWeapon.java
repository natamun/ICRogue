package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Projectile;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Positionable;

public interface PlayerUsingWeapon {
    /**
     * We want that all weapon have a projectile & a cool down.
     */
    Projectile getWeaponProjectiles(Area area, Orientation orientation, DiscreteCoordinates cellInFrontOfActor);
    double getWeaponCoolDown();

}
