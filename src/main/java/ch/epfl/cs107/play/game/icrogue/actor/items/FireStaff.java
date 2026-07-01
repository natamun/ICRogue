package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.FireBall;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Projectile;
import ch.epfl.cs107.play.math.DiscreteCoordinates;


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
