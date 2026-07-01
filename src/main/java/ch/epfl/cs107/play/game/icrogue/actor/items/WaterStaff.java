package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Projectile;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.WaterBall;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public class WaterStaff extends Weapon{
    private double waterStaffRateFire = 0.5;

    /**
     * Creates an instance of a Water Staff.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */

    public WaterStaff(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position, 222);

        setWeaponCoolDown(waterStaffRateFire);
        setCollectedText("You found the Water Staff ! Press S to switch weapon.");

        setGearIconPath("zelda/staff_water.icon");


        Sprite[] waterStaff = Sprite.extractSprites("zelda/staff_water",8,1f,1f,this,32,32);
        Animation animatedWaterStaff = new Animation(2, waterStaff);
        setAnimation(animatedWaterStaff);
    }

    @Override
    public Projectile getWeaponProjectiles(Area area, Orientation orientation, DiscreteCoordinates cellInFrontOfActor) {
        return new WaterBall(area,orientation, cellInFrontOfActor);
    }
}
