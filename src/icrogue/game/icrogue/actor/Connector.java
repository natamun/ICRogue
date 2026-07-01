package icrogue.game.icrogue.actor;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.AreaEntity;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.areagame.actor.Sprite;
import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.game.icrogue.handler.ICRogueInteractionHandler;
import icrogue.math.DiscreteCoordinates;
import icrogue.math.Vector;
import icrogue.window.Canvas;

import java.util.List;

/*
 * Author :     Natalino MUNARI
 * Date :       05.12.2022{
 */
public class Connector extends AreaEntity {
    public enum ICRogueConnectorType{
        OPEN,
        CLOSED,
        LOCKED,
        INVISIBLE
    }
    private Sprite closedDoor;
    private Sprite lockedDoor;
    private Sprite invisibleDoor;
    private ICRogueConnectorType state;
    private String destination;
    private DiscreteCoordinates spawn;
    private int keyId;

    /**
     * Default AreaEntity constructor
     *
     * @param area        (Area): Owner area. Not null
     * @param orientation (Orientation): Initial orientation of the entity in the Area. Not null
     * @param position    (DiscreteCoordinate): Initial position of the entity in the Area. Not null
     */
    public Connector(Area area, Orientation orientation, DiscreteCoordinates position,
                     ICRogueConnectorType state, String destination, DiscreteCoordinates spawn, int keyId) {
        super(area, orientation, position);
        this.state = state;
        this.destination = destination;
        this.spawn = spawn;
        this.keyId = keyId;
        closedDoor = new Sprite("icrogue/door_"+getOrientation().opposite().ordinal(),
                (getOrientation().ordinal()+1)%2+1,
                getOrientation().ordinal()%2+1, this);
        lockedDoor = new Sprite("icrogue/lockedDoor_"+getOrientation().opposite().ordinal(),
                (getOrientation().ordinal()+1)%2+1,
                getOrientation().ordinal()%2+1, this);
        invisibleDoor = new Sprite("icrogue/invisibleDoor_"+getOrientation().opposite().ordinal(),
                (getOrientation().ordinal()+1)%2+1,
                getOrientation().ordinal()%2+1, this);
    }

    public ICRogueConnectorType getState(){
        return state;
    }
    public void closeIt(){
        this.state = ICRogueConnectorType.CLOSED;
    }
    public void openIt(){
        this.state = ICRogueConnectorType.OPEN;
    }
    public void lockIt(){
        this.state = ICRogueConnectorType.LOCKED;
    }
    public boolean isClosed(){ return this.state == ICRogueConnectorType.CLOSED; }
    public boolean isOpen(){ return this.state == ICRogueConnectorType.OPEN; }
    public boolean isLocked(){ return this.state == ICRogueConnectorType.LOCKED; }
    public boolean isInvisible(){ return this.state == ICRogueConnectorType.INVISIBLE; }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public String getDestination() {
        return destination;
    }
    public void setKeyId(int keyId){
        this.keyId = keyId;
    }
    public int getKeyID(){
        return keyId;
    }
    public DiscreteCoordinates getSpawn() {
        return spawn;
    }

    @Override
    public void draw(Canvas canvas) {
        switch(getState()){
            case CLOSED -> closedDoor.draw(canvas);
            case LOCKED -> lockedDoor.draw(canvas);
            case INVISIBLE -> invisibleDoor.draw(canvas);
        }
    }
    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        DiscreteCoordinates coord = getCurrentMainCellCoordinates();
        return List.of(coord , coord.jump(
                new Vector((getOrientation().ordinal()+1)%2, getOrientation().ordinal()%2)));

    }
    @Override
    public boolean takeCellSpace() {
        if(isOpen()){
            return false;
        }
        return true;
    }
    @Override
    public boolean isCellInteractable() {
        if(isOpen()){
            return true;
        }
        return false;
    }
    @Override
    public boolean isViewInteractable() {
        if(isOpen()){
            return false;
        }
        return true;
    }
    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {
        ((ICRogueInteractionHandler) v).interactWith(this , isCellInteraction);
    }
}
