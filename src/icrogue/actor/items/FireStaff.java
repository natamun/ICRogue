package icrogue.game.icrogue.actor.items;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Animation;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.areagame.actor.Sprite;
import icrogue.game.icrogue.actor.projectiles.FireBall;
import icrogue.game.icrogue.actor.projectiles.Projectile;
import icrogue.math.DiscreteCoordinates;


public class FireStaff extends Weapon {
    /**
     * Creates an instance of a Fire Staff
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public FireStaff(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position, 111);

        setCollectedText("Congratulations, you found the Fire Staff ! Press Q to use it.");
        setGearIconPath("zelda/staff_fire.icon");

        Sprite[] fireStaff = Sprite.extractSprites("zelda/staff_fire_burning",
                8,1f,1f,this,32,32);
        Animation animatedFireStaff = new Animation(2, fireStaff);
        setAnimation(animatedFireStaff);

    }
    @Override
    public Projectile getWeaponProjectiles(Area area, Orientation orientation, DiscreteCoordinates cellInFrontOfActor) {
        return new FireBall(area,orientation, cellInFrontOfActor);
    }


}
