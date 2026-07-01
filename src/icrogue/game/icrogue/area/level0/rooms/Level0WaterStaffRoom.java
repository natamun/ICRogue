package icrogue.game.icrogue.area.level0.rooms;

import icrogue.game.areagame.actor.Orientation;
import icrogue.game.icrogue.actor.friendlyNPC.NinjaPNJ;
import icrogue.game.icrogue.actor.items.WaterStaff;
import icrogue.math.DiscreteCoordinates;

public class Level0WaterStaffRoom extends Level0ItemRoom{
    /**
     * Fire Staff Room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0WaterStaffRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
        addItem(new WaterStaff(this, Orientation.UP,new DiscreteCoordinates(5,5)));
    }
    @Override
    protected void createArea(){
        //register the friendly ninja and calls the createArea from Level0ItemRoom
        super.createArea();
        registerActor(new NinjaPNJ(this, Orientation.UP,new DiscreteCoordinates(8,8)));
    }
}
