package icrogue.game.icrogue.area;

import icrogue.math.DiscreteCoordinates;

public interface ConnectorInRoom {
    int getIndex();
    DiscreteCoordinates getDestination();
}