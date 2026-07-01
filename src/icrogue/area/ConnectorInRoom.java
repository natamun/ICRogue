package icrogue.area;

import icrogue.engine.math.DiscreteCoordinates;

public interface ConnectorInRoom {
    int getIndex();
    DiscreteCoordinates getDestination();
}