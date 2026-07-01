package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.area.ConnectorInRoom;
import ch.epfl.cs107.play.game.icrogue.area.ICRogueRoom;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import java.util.ArrayList;
import java.util.List;


public class Level0Room extends ICRogueRoom {

    public enum Level0Connectors implements ConnectorInRoom {
        // ordre des attributs: position , destination , orientation
        W(new DiscreteCoordinates(0, 4),
                new DiscreteCoordinates(8, 5), Orientation.LEFT),
        S(new DiscreteCoordinates(4, 0),
                new DiscreteCoordinates(5, 8), Orientation.DOWN),
        E(new DiscreteCoordinates(9, 4),
                new DiscreteCoordinates(1, 5), Orientation.RIGHT),
        N(new DiscreteCoordinates(4, 9),
                new DiscreteCoordinates(5, 1), Orientation.UP);

        final DiscreteCoordinates position;
        final DiscreteCoordinates destination;
        final Orientation orientation;

        Level0Connectors(DiscreteCoordinates position,
                         DiscreteCoordinates destination, Orientation orientation) {
            this.position = position;
            this.destination = destination;
            this.orientation = orientation;
        }
        @Override
        public int getIndex() {
            return ordinal();
        }

        @Override
        public DiscreteCoordinates getDestination() {
            return destination;
        }


        static List<Orientation> getAllConnectorsOrientation(){

            List<Orientation> AllConnectorsOrientation = new ArrayList<>();
            for(Level0Connectors lc : Level0Connectors.values()){
                AllConnectorsOrientation.add(lc.orientation);
            }
            return AllConnectorsOrientation;
        }
        static List <DiscreteCoordinates> getAllConnectorsPosition(){
            List<DiscreteCoordinates> AllConnectorsPosition = new ArrayList<>();
            for(Level0Connectors lc : Level0Connectors.values()){
                AllConnectorsPosition.add(lc.position);
            }
            return AllConnectorsPosition;
        }

        static List <DiscreteCoordinates> getAllConnectorsSpawnPosition(){
            List<DiscreteCoordinates> AllConnectorSpawnPosition = new ArrayList<>();
            for(Level0Connectors lc : Level0Connectors.values()){
                AllConnectorSpawnPosition.add(lc.destination);
            }
            return AllConnectorSpawnPosition;
        }
    }

    /**
     * Level0Room constructor.
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0Room(DiscreteCoordinates roomCoordinates){
        super(Level0Connectors.getAllConnectorsPosition(), Level0Connectors.getAllConnectorsOrientation(),
                Level0Connectors.getAllConnectorsSpawnPosition(),
                "icrogue/Level0Room", roomCoordinates);

    }

    @Override
    public DiscreteCoordinates getPlayerSpawnPosition() {
        return new DiscreteCoordinates(2,2);
    }

    @Override
    protected void createArea() {
        super.createArea();
    }

}
