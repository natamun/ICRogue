package icrogue.actor.items;

import icrogue.engine.game.areagame.Area;
import icrogue.engine.game.areagame.actor.Animation;
import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.engine.game.areagame.actor.Sprite;
import icrogue.actor.projectiles.Projectile;
import icrogue.actor.projectiles.WaterBall;
import icrogue.engine.math.DiscreteCoordinates;

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
