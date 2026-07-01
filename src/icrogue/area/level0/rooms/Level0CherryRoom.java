package icrogue.area.level0.rooms;

import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.actor.items.Cherry;
import icrogue.engine.math.DiscreteCoordinates;

public class Level0CherryRoom extends Level0ItemRoom{
    /**
     * Cherry room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0CherryRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
        addItem(new Cherry(this, Orientation.UP,new DiscreteCoordinates(5,5)));
    }
}
