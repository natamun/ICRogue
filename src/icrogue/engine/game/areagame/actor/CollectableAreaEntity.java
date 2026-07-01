package icrogue.engine.game.areagame.actor;

import icrogue.engine.game.areagame.Area;
import icrogue.engine.math.DiscreteCoordinates;


public abstract class CollectableAreaEntity extends AreaEntity{

    /// Flag on the collected status
    private boolean isCollected;


    /**
     * Default CollectableAreaEntity constructor
     * @param area (Area): Owner area. Not null
     * @param position (Coordinate): Initial position of the entity. Not null
     * @param orientation (Orientation): Initial orientation of the entity. Not null
     */
    public CollectableAreaEntity(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        isCollected = false;
    }


    /**
     * Alternative CollectableAreaEntity constructor
     * @param area (Area): Owner area. Not null
     * @param position (Coordinate): Initial position of the entity. Not null
     * @param orientation (Orientation): Initial orientation of the entity. Not null
     * @param isCollected (boolean): initial collected status of this
     */
    public CollectableAreaEntity(Area area, Orientation orientation, DiscreteCoordinates position, boolean isCollected) {
        super(area, orientation, position);
        this.isCollected = isCollected;
    }


    /** Collect the object (remove it form the area actor list and set flag to true) */
    public void collect() {
        if (!isCollected) {
            isCollected = getOwnerArea().unregisterActor(this);
        }
    }

    public boolean isCollected(){
        return isCollected;
    }
}
