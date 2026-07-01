package icrogue.game.icrogue.actor;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.*;
import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.game.icrogue.handler.ICRogueInteractionHandler;
import icrogue.math.DiscreteCoordinates;
import icrogue.window.Canvas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Author :     Natalino MUNARI
 * Date :       03.12.2022{
 */
public class ICRogueActor extends MovableAreaEntity {
    private Sprite sprite;
    private Animation animation;
    private ICRogueInteractionHandler icRogueInteractionHandler;

    /**
     * Default MovableAreaEntity constructor
     *
     * @param area        (Area): Owner area. Not null
     * @param orientation (Orientation): Initial orientation of the entity. Not null
     * @param position    (Coordinate): Initial position of the entity. Not null
     */
    public ICRogueActor(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        icRogueInteractionHandler = new ICRogueActorInteractionHandler();

    }

    //--------------------------ICRogueActor methods------------------
    public void enterArea(Area area, DiscreteCoordinates position){
        area.registerActor(this);
        setOwnerArea(area);
        setCurrentPosition(position.toVector());
        resetMotion();
    }

    public void leaveArea(){
        getOwnerArea().unregisterActor(this);
    }

    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }

    public List<DiscreteCoordinates> getFieldOfViewCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates().jump(getOrientation().toVector()));}

    /**
     * @return the cell in front of the actor.
     */
    public DiscreteCoordinates getCellInFrontOfActor(){
        return getCurrentMainCellCoordinates().jump(getOrientation().toVector());
    }

    /**
     * @return all the cell that an "actor with 4 eyes (1 for each direction)" can see.
     */
    public List<DiscreteCoordinates> getAllCellInLineOfActor(){
        int height = getOwnerArea().getHeight() - 2;
        int width = getOwnerArea().getWidth() - 2;
        DiscreteCoordinates currentPosition = getCurrentMainCellCoordinates();
        int north = height - currentPosition.y;
        int south = (height - 1) - north;
        int east = width - currentPosition.x;
        int west = (width - 1) - east;
        List<DiscreteCoordinates> allCellInFrontOfActor = new ArrayList<>();
        for(int i = 0; i < north; ++i){
            allCellInFrontOfActor.add(currentPosition.jump(0,i + 1));
        }
        for(int i = 0; i > -south; --i){
            allCellInFrontOfActor.add(currentPosition.jump(0,i - 1));
        }
        for(int i = 0; i < east; ++i){
            allCellInFrontOfActor.add(currentPosition.jump(i + 1,0));
        }
        for(int i = 0; i > -west; --i){
            allCellInFrontOfActor.add(currentPosition.jump(i - 1,0));
        }
        return allCellInFrontOfActor;
    }

    /**
     * @return all the cell in the room for an actor that see all the room.
     */
    public List<DiscreteCoordinates> getAllCellInRoom(){
        List<DiscreteCoordinates> allCellInRoom = new ArrayList<>();
        for(int i = 0; i < getOwnerArea().getWidth(); ++i){
            for(int j = 0; j < getOwnerArea().getHeight(); ++j){
                allCellInRoom.add(new DiscreteCoordinates(i,j));
            }
        }
        return allCellInRoom;
    }

    protected void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
    protected void setAnimation(Animation animation){
        this.animation = animation;
    }
    protected void setInteractionHandler(ICRogueActorInteractionHandler icr){
        icRogueInteractionHandler = icr;
    }

    /**
     * Drawing an animation, depending on the orientation of the actor.
     *
     * We do not add the conditions necessary to draw animation on those method because it can be different from actors.
     *
     * @param animation (Animation[]): a set of 4 animations, for each direction.
     * @param orientation (Orientation): orientation of the actor
     * @param canvas (Canvas): the canvas.
     */
    protected void animationDraw(Animation[] animation, Orientation orientation, Canvas canvas){
        switch(orientation){
            case DOWN -> animation[0].draw(canvas);
            case RIGHT -> animation[1].draw(canvas);
            case UP -> animation[2].draw(canvas);
            case LEFT -> animation[3].draw(canvas);
        }
    }

    /**
     * Drawing the actor if he did not need an animation, depending on the orientation of the actor.
     *
     * We do not add the conditions necessary to draw a sprite on those method because it can be different from actors.
     *
     * @param sprite (Sprite[][]): a set of 4 animations, for each direction.
     * @param orientation (Orientation): orientation of the actor
     * @param canvas (Canvas): the canvas.
     */
    protected void noAnimationDraw(Sprite[][] sprite, Orientation orientation, Canvas canvas){
        switch(orientation){
            case DOWN -> sprite[0][0].draw(canvas);
            case RIGHT -> sprite[1][0].draw(canvas);
            case UP -> sprite[2][0].draw(canvas);
            case LEFT -> sprite[3][0].draw(canvas);
        }
    }

    /**
     * Updating animation in case of actors that have 4 orientations.
     *
     * @param animation (Animation[]): a set of 4 animations, for each direction.
     * @param deltaTime (float): the deltaTime.
     */
    protected void updateOrientedAnimation(Animation[] animation, float deltaTime){
        for(int i = 0; i < 4; ++i){
            animation[i].update(deltaTime);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if(sprite != null){
            sprite.draw(canvas);
        }
        if(animation != null){
            animation.draw(canvas);
        }
    }

    public void update(float deltaTime) {
        if(animation != null){
            animation.update(deltaTime);
        }
        super.update(deltaTime);
    }

    /**
     * Interactions Handler of all actors, currently empty, we suppose that all actors do not have communs interactions.
     */
    protected class ICRogueActorInteractionHandler implements ICRogueInteractionHandler {    }

    @Override
    public boolean takeCellSpace() { return false; }
    @Override
    public boolean isCellInteractable() { return false; }
    @Override
    public boolean isViewInteractable() { return false; }
    public void interactWith(Interactable other, boolean isCellInteraction){
        other.acceptInteraction(icRogueInteractionHandler, isCellInteraction);
    }
    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {
        v.interactWith(this , isCellInteraction);
    }

}
