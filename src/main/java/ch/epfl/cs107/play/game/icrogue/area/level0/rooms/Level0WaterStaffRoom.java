package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.friendlyNPC.NinjaPNJ;
import ch.epfl.cs107.play.game.icrogue.actor.items.WaterStaff;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

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
