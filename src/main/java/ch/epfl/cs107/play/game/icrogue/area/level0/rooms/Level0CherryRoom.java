package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.items.Cherry;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

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
