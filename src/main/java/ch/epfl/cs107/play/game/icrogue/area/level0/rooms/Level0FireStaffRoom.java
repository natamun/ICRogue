package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.friendlyNPC.NinjaPNJ;
import ch.epfl.cs107.play.game.icrogue.actor.items.FireStaff;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public class Level0FireStaffRoom extends Level0ItemRoom{
    /**
     * Fire Staff Room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0FireStaffRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
        addItem(new FireStaff(this, Orientation.UP,new DiscreteCoordinates(5,5)));
    }

    @Override
    protected void createArea(){
        //register the friendly ninja and calls the createArea from Level0ItemRoom
        super.createArea();
        registerActor(new NinjaPNJ(this, Orientation.UP,new DiscreteCoordinates(8,8)));
    }
}
