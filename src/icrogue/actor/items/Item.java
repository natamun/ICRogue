package icrogue.game.icrogue.actor.items;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Animation;
import icrogue.game.areagame.actor.CollectableAreaEntity;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.areagame.actor.Sprite;
import icrogue.math.DiscreteCoordinates;
import icrogue.window.Canvas;
import java.util.Collections;
import java.util.List;

abstract public class Item extends CollectableAreaEntity {
    private Sprite sprite;
    private Animation animation;

    /**
     * Constructor of an item.
     * @param area (Area) the area containing the item
     * @param orientation (Orientation) the  orientation of the item.
     * @param position (DiscreteCoordinates) the position of the item.
     */
    public Item(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
    }

    @Override
    public void draw(Canvas canvas) {
        //displays item if it is not collected
        if(!isCollected()){
            if(sprite != null){
                sprite.draw(canvas);
            }
            if(animation != null){
                animation.draw(canvas);
            }
        }
    }
    @Override
    public void update(float deltaTime){
        //updates the animation if it exists
        if(animation != null){
            animation.update(deltaTime);
        }
    }

    /**
     * set the sprite of the item
     * @param sprite (Sprite) the sprite that will be set
     */

    protected void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    /**
     * set the animation of the item
     * @param animation (Animation) the animation that will be set
     */
    protected void setAnimation(Animation animation){ this.animation = animation;}

    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }

    @Override
    public boolean takeCellSpace() {
        return false;
    }

    @Override
    public boolean isCellInteractable() {
        return true;
    }

    @Override
    public boolean isViewInteractable() {
        return false;
    }


}
