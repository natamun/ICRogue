package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import static ch.epfl.cs107.play.game.icrogue.area.level0.Level0.BOSS_KEY_ID;

public class Key extends Item{
    private int keyID;
    /**
     * Creates an instance of a Key.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     * @param keyId (int) the id used to identify the key type.
     * */
    public Key(Area area, Orientation orientation, DiscreteCoordinates position, int keyId) {
        super(area, orientation, position);
        this.keyID = keyId;
        //If the key is a boss key, we draw a different sprite.
        if (keyId == BOSS_KEY_ID){
            setSprite(new Sprite("icrogue/key2", 0.75f, 0.75f, this));
        }
        else {
            setSprite(new Sprite("icrogue/key", 0.75f, 0.75f, this));
        }
    }

    /**
     * used to get the ID of a key
     * @return the key ID.
     */
    public int getKeyID() {
        return keyID;
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean wantsViewInteraction){
        if(!isCollected()){
            ((ICRogueInteractionHandler) v).interactWith(this , wantsViewInteraction);
        }
    }
}
