package icrogue.area.level0.rooms;

import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.actor.friendlyNPC.NinjaPNJ;
import icrogue.actor.items.FireStaff;
import icrogue.engine.math.DiscreteCoordinates;

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
