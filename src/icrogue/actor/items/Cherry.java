package icrogue.actor.items;

import icrogue.engine.game.areagame.Area;
import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.engine.game.areagame.actor.Sprite;
import icrogue.engine.game.areagame.handler.AreaInteractionVisitor;
import icrogue.handler.ICRogueInteractionHandler;
import icrogue.engine.math.DiscreteCoordinates;

public class Cherry extends Item{

    /**
     * Creates an instance of a Cherry.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public Cherry(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        setSprite(new Sprite("icrogue/cherry", 0.6f, 0.6f, this));
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean wantsViewInteraction){
        if(!isCollected()){
            ((ICRogueInteractionHandler) v).interactWith(this , wantsViewInteraction);
        }
    }
}
