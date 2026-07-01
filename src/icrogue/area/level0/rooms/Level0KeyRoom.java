package icrogue.area.level0.rooms;

import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.actor.items.Key;
import icrogue.engine.math.DiscreteCoordinates;

public class Level0KeyRoom extends Level0ItemRoom{

    /**
     * Key Room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     * @param keyId (int): the id used to identify what key type will be but int the room.
     */
    public Level0KeyRoom(DiscreteCoordinates roomCoordinates, int keyId) {
        super(roomCoordinates);
        addItem(new Key(this, Orientation.UP,new DiscreteCoordinates(5,5), keyId));

    }
}
