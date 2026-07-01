package icrogue.game.icrogue.actor.items;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Animation;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.areagame.actor.Sprite;
import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.game.icrogue.handler.ICRogueInteractionHandler;
import icrogue.math.DiscreteCoordinates;
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
