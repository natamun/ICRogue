package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.items.Key;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

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
