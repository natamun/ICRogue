package icrogue.game.icrogue.area;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Background;
import icrogue.game.areagame.actor.Orientation;
import icrogue.game.icrogue.ICRogue;
import icrogue.game.icrogue.ICRogueBehavior;
import icrogue.game.icrogue.actor.Connector;
import icrogue.game.icrogue.area.level0.rooms.Level0Room;
import icrogue.io.FileSystem;
import icrogue.math.DiscreteCoordinates;
import icrogue.signal.logic.Logic;
import icrogue.window.Window;
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