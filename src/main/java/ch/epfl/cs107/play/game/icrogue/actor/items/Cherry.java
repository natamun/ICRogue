package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

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
