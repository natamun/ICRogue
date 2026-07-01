package icrogue.area;

import icrogue.engine.game.areagame.Area;
import icrogue.engine.game.areagame.actor.Background;
import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.ICRogue;
import icrogue.ICRogueBehavior;
import icrogue.actor.Connector;
import icrogue.area.level0.rooms.Level0Room;
import icrogue.engine.io.FileSystem;
import icrogue.engine.math.DiscreteCoordinates;
import icrogue.engine.signal.logic.Logic;
import icrogue.engine.window.Window;
import java.util.ArrayList;
import java.util.List;

public abstract class ICRogueRoom extends Area implements Logic {
    private DiscreteCoordinates roomCoordinates;
    private ICRogueBehavior behavior;
    protected String behaviorName;
    protected boolean visited;
    protected List<Connector> connectorsList;

    /**
     * Create the area by adding it all actors called by begin method
     *
     * @param connectorsCoordinates : List of all connectors coordinates.
     * @param connectorsOrientations : List of all connectors orientations.
     * @param connectorsSpawnPosition : List of all spawn coordinates (where the player spawn when he uses connector).
     * @param behaviorName : the behaviorName of the current level.
     * @param roomCoordinates : the coordinate of the current room on the map.
     */
    public ICRogueRoom(List<DiscreteCoordinates> connectorsCoordinates,
                       List<Orientation> connectorsOrientations,
                       List<DiscreteCoordinates> connectorsSpawnPosition,
                       String behaviorName, DiscreteCoordinates roomCoordinates){
        this.behaviorName = behaviorName;
        this.roomCoordinates = roomCoordinates;
        this.connectorsList = new ArrayList<>();

        for(int i = 0 ; i < Level0Room.Level0Connectors.values().length ; ++i){
            this.connectorsList.add(new Connector(
                    this,connectorsOrientations.get(i),connectorsCoordinates.get(i),
                    Connector.ICRogueConnectorType.INVISIBLE,this.getTitle(),
                    connectorsSpawnPosition.get(i),0));
        }
    }

    protected void createArea(){
        visited = true;
        registerActor(new Background(this, behaviorName));
        for(Connector c : connectorsList){
            registerActor(c);
        }
    }

    @Override
    public final float getCameraScaleFactor() {
        return ICRogue.CAMERA_SCALE_FACTOR;
    }
    public abstract DiscreteCoordinates getPlayerSpawnPosition();
    @Override
    public boolean isOn() {
        return visited;
    }
    @Override
    public boolean isOff() {
        return false;
    }
    @Override
    public float getIntensity() { return 0; }
    public String getTitle() { return "icrogue/level0" + roomCoordinates.x + roomCoordinates.y; }

    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
        if (super.begin(window, fileSystem)) {
            behavior = new ICRogueBehavior(window, behaviorName);
            setBehavior(behavior);
            createArea();
            return true;
        }
        return false;
    }
    @Override
    public void update(float deltaTime) {
        if(isOn()) {
            for (Connector connector : connectorsList) {
                if (!connector.isInvisible() && !connector.isLocked()) {
                    connector.openIt();
                }
            }
        }
        super.update(deltaTime);
    }
}