package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
public class Heart extends Item {
    /**
     * Creates an instance of a heart
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public Heart(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);

        Sprite[] Heart = Sprite.extractSprites("zelda/heart",4,1f,1f,this,16,16);
        Animation animatedHeart = new Animation(2, Heart);
        setAnimation(animatedHeart);
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean wantsViewInteraction){
        if(!isCollected()){
            ((ICRogueInteractionHandler) v).interactWith(this , wantsViewInteraction);
        }
    }

}
