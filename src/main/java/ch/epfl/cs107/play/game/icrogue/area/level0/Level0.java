package ch.epfl.cs107.play.game.icrogue.area.level0;

import ch.epfl.cs107.play.game.icrogue.area.ConnectorInRoom;
import ch.epfl.cs107.play.game.icrogue.area.Level;
import ch.epfl.cs107.play.game.icrogue.area.level0.rooms.*;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level0 extends Level {
    public enum RoomType {
        //We do not recommend to change those value, but you can to get a groovy map ! Don't cry if you get lost !
        FIRE_STAFF_ROOM(1),
        SPAWN(1),
        TURRET_KEY_ROOM(1),
        NORMAL(1),

        //You are not suppose to modifie this distribution, because it's restricted room with special case !
        TURRET_ROOM(1),
        WATER_STAFF_ROOM(1),
        BOSS_KEY_ROOM(1),
        BOSS_ROOM(1);


        int nbRooms;

        RoomType(int nbrRooms){
            this.nbRooms = nbrRooms;
        }
        private int getNbRooms(){return nbRooms;}
    }

    final static public int TURRET_ROOM_KEY_ID = 1;
    final static public int BOSS_KEY_ID = 666;
    private MapState[][] placementMap;
    private static int[] roomDistributions = getRoomDistribution();

    //----------------Attributs of different maps already created------------
    private static int[] width = {4,4};
    private static int[] height = {2,3};
    private static DiscreteCoordinates[] roomSpawn = {new DiscreteCoordinates(1,1), new DiscreteCoordinates(2,2)};
    private static DiscreteCoordinates[] bossRoom = { new DiscreteCoordinates(3,0), new DiscreteCoordinates(2,0)};

    /**
     * Level0 constructor.
     * @param random (boolean): true if the game generate a random map.
     * @param mapID (int): the id used to identify a map already created.
     */
    public Level0(boolean random, int mapID){
        super(random,roomSpawn[mapID], roomDistributions, width[mapID], height[mapID]);
        if(!random){
            generateFixedMap(mapID);
            setBossRoomLocation(bossRoom[mapID]);
            setStartPosition(roomSpawn[mapID]);

        }else{
            placementMap = generateRandomRoomPlacement();
            printMap(placementMap);
            generateRandomMap(placementMap);

        }
    }

    /**
     * @return the room distribution
     */
    private  static int[] getRoomDistribution(){
        int[] roomDistribution = new int[RoomType.values().length];
        int pos = 0;
        for(RoomType rt : RoomType.values()){
            roomDistribution[pos] = rt.getNbRooms();
            ++pos;
        }
        return roomDistribution;
    }

    /**
     * @param mapID (int): the map ID.
     */
    private void generateFixedMap(int mapID){
        switch(mapID){
            case 0 :
                generateDebugMap();
                break;
            case 1 :
                generateMap1();
                break;
        }
    }

    /**
     * Generating map 1.
     */
    private void generateMap1() {
        DiscreteCoordinates room00 = new DiscreteCoordinates(0, 0);
        setRoom(room00, new Level0WaterStaffRoom(room00));
        setRoomConnector(room00, "icrogue/level010", Level0Room.Level0Connectors.E);
        setRoomConnector(room00, "icrogue/level001", Level0Room.Level0Connectors.S);

        DiscreteCoordinates room10 = new DiscreteCoordinates(1,0);
        setRoom(room10, new Level0KeyRoom(room10, BOSS_KEY_ID));
        setRoomConnector(room10, "icrogue/level000", Level0Room.Level0Connectors.W);

        DiscreteCoordinates room20 = new DiscreteCoordinates(2,0);
        setRoom(room20,  new Level0TurretRoom(room20));
        setRoomConnector(room20, "icrogue/level021", Level0Room.Level0Connectors.S);

        DiscreteCoordinates room01 = new DiscreteCoordinates(0,1);
        setRoom(room01,  new Level0TurretRoom(room01));
        setRoomConnector(room01, "icrogue/level011", Level0Room.Level0Connectors.E);
        setRoomConnector(room01, "icrogue/level000", Level0Room.Level0Connectors.N);

        DiscreteCoordinates room11 = new DiscreteCoordinates(1,1);
        setRoom(room11,  new Level0FireStaffRoom(room11));
        setRoomConnector(room11, "icrogue/level021", Level0Room.Level0Connectors.E);
        lockRoomConnector(room11, Level0Room.Level0Connectors.W,  TURRET_ROOM_KEY_ID);
        setRoomConnectorDestination(room11, "icrogue/level001", Level0Room.Level0Connectors.W);

        DiscreteCoordinates room21 = new DiscreteCoordinates(2,1);
        setRoom(room21, new Level0Room(room21));
        setRoomConnector(room21, "icrogue/level022", Level0Room.Level0Connectors.S);
        setRoomConnector(room21, "icrogue/level011", Level0Room.Level0Connectors.W);
        setRoomConnector(room21, "icrogue/level031", Level0Room.Level0Connectors.E);
        lockRoomConnector(room21, Level0Room.Level0Connectors.N,  BOSS_KEY_ID);
        setRoomConnectorDestination(room21, "icrogue/level020", Level0Room.Level0Connectors.N);

        DiscreteCoordinates room31 = new DiscreteCoordinates(3, 1);
        setRoom (room31, new Level0KeyRoom(room31, TURRET_ROOM_KEY_ID));
        setRoomConnector(room31, "icrogue/level021", Level0Room.Level0Connectors.W);

        DiscreteCoordinates room22 = new DiscreteCoordinates(2, 2);
        setRoom (room22, new Level0Room(room22));
        setRoomConnector(room22, "icrogue/level021", Level0Room.Level0Connectors.N);
    }

    /**
     * Generating a map that have predefined setup to debug.
     */
    private void generateDebugMap() {
        DiscreteCoordinates room00 = new DiscreteCoordinates(0, 0);
        setRoom(room00, new Level0TurretRoom(room00));
        setRoomConnector(room00, "icrogue/level010", Level0Room.Level0Connectors.E);

        DiscreteCoordinates room10 = new DiscreteCoordinates(1,0);
        setRoom(room10, new Level0KeyRoom(room10, TURRET_ROOM_KEY_ID));
        lockRoomConnector(room10, Level0Room.Level0Connectors.W,  TURRET_ROOM_KEY_ID);
        setRoomConnectorDestination(room10, "icrogue/level000", Level0Room.Level0Connectors.W);
        setRoomConnector(room10, "icrogue/level011", Level0Room.Level0Connectors.S);
        setRoomConnector(room10, "icrogue/level020", Level0Room.Level0Connectors.E);


        DiscreteCoordinates room20 = new DiscreteCoordinates(2,0);
        setRoom(room20,  new Level0KeyRoom(room20, BOSS_KEY_ID));
        lockRoomConnector(room20, Level0Room.Level0Connectors.E,  BOSS_KEY_ID);
        setRoomConnectorDestination(room20, "icrogue/level030", Level0Room.Level0Connectors.E);
        setRoomConnector(room20, "icrogue/level010", Level0Room.Level0Connectors.W);
        setRoomConnector(room20, "icrogue/level021", Level0Room.Level0Connectors.S);

        DiscreteCoordinates room30 = new DiscreteCoordinates(3,0);
        setRoom(room30, new Level0BossRoom(room30));
        setRoomConnector(room30, "icrogue/level020", Level0Room.Level0Connectors.W);

        DiscreteCoordinates room11 = new DiscreteCoordinates(1, 1);
        setRoom (room11, new Level0FireStaffRoom(room11));
        setRoomConnector(room11, "icrogue/level010", Level0Room.Level0Connectors.N);
        setRoomConnector(room11, "icrogue/level021", Level0Room.Level0Connectors.E);

        DiscreteCoordinates room21 = new DiscreteCoordinates(2,1);
        setRoom(room21,  new Level0WaterStaffRoom(room21));
        setRoomConnector(room21, "icrogue/level020", Level0Room.Level0Connectors.N);
        setRoomConnector(room21, "icrogue/level011", Level0Room.Level0Connectors.W);
    }

    /**
     * Generating a random map.
     * @param placementMap (MapState[][]): the template of the random map.
     */
    private void generateRandomMap(MapState[][] placementMap){
        //Initialising a list of not restricted room
        List<DiscreteCoordinates> exploredRoom = new ArrayList<>();

        //calculate the numbers of room required.
        int nbRooms = 0;
        for (Integer rd : roomDistributions) {
            nbRooms += rd;
        }

        //Setting all rooms that have restricted dispositions.
        for(int i = 0; i < nbRooms; ++i) {
            for (int j = 0; j < nbRooms; ++j) {
                DiscreteCoordinates coords = new DiscreteCoordinates(i, j);

                switch (placementMap[i][j]) {
                    case TURRET_ROOM:
                        setRoom(coords, new Level0TurretRoom(coords));
                        setAllConnectorToMapState(coords, MapState.EXPLORED, MapState.WEAKNESS_WEAPON_BOSS_ROOM);
                        break;

                    case WEAKNESS_WEAPON_BOSS_ROOM:
                        setRoom(coords, new Level0WaterStaffRoom(coords));
                        setAllConnectorToMapState(coords, MapState.TURRET_ROOM, MapState.BOSS_KEY_ROOM);
                        break;

                    case BOSS_KEY_ROOM:
                        setRoom(coords, new Level0KeyRoom(coords, BOSS_KEY_ID));
                        setAllConnectorToMapState(coords, MapState.WEAKNESS_WEAPON_BOSS_ROOM);
                        break;

                    case BOSS_ROOM:
                        setRoom(coords, new Level0BossRoom(coords));
                        setBossRoomLocation(coords);
                        setAllConnectorToMapState(coords, MapState.EXPLORED);
                        break;

                    //Adding all not restricted room to a list.
                    case EXPLORED:
                        exploredRoom.add(coords);
                        break;
                }
            }
        }
        //Shuffling the list to keep random generations
        //If not, there will always be a tendency that set the turret key room at top left, etc...
        Collections.shuffle(exploredRoom);

        //Setting all rooms that have not restricted dispositions, while they distributions is not equals to 0.
        for(int k = 0; k < exploredRoom.size(); ++k){
            DiscreteCoordinates coords = exploredRoom.get(k);

            if(roomDistributions[RoomType.TURRET_KEY_ROOM.ordinal()] != 0){
                setRoom(coords, new Level0KeyRoom(coords, TURRET_ROOM_KEY_ID));
                setAllConnectorNotRestrictedRoom(coords);
                roomDistributions[RoomType.TURRET_KEY_ROOM.ordinal()] -= 1;

            }else if(roomDistributions[RoomType.FIRE_STAFF_ROOM.ordinal()] != 0){
                setRoom(coords, new Level0FireStaffRoom(coords));
                setAllConnectorNotRestrictedRoom(coords);
                roomDistributions[RoomType.FIRE_STAFF_ROOM.ordinal()] -= 1;

            }else if(roomDistributions[RoomType.SPAWN.ordinal()] != 0){
                setRoom(coords, new Level0Room(coords));
                setStartPosition(coords);
                setAllConnectorNotRestrictedRoom(coords);
                roomDistributions[RoomType.SPAWN.ordinal()] -= 1;

            }else if(roomDistributions[RoomType.NORMAL.ordinal()] != 0){
                setRoom(coords, new Level0Room(coords));
                setAllConnectorNotRestrictedRoom(coords);
                roomDistributions[RoomType.NORMAL.ordinal()] -= 1;
            }
        }
    }

    /**
     * Calculating the position of the connector depending on the current room and the destination.
     * @param roomCoordinate (DiscreteCoordinates): Coordinates of the currentRoom.
     * @param destinationCoordinate (DiscreteCoordinates): Coordinates of the destination.
     */
    private ConnectorInRoom calculateConnectorPos(DiscreteCoordinates roomCoordinate, DiscreteCoordinates destinationCoordinate){
        ConnectorInRoom connector = null;
        int dx = roomCoordinate.x - destinationCoordinate.x;
        int dy = roomCoordinate.y - destinationCoordinate.y;
        if(dx == 1){
            connector = Level0Room.Level0Connectors.W;
        }else if(dx == -1){
            connector = Level0Room.Level0Connectors.E;
        }else if(dy == 1){
            connector = Level0Room.Level0Connectors.N;
        }else if(dy == -1){
            connector = Level0Room.Level0Connectors.S;
        }
        return connector;
    }

    /**
     * Setting all connectors of the currentRoom where destination is some MapState.
     * @param coords (DiscreteCoordinates): Coordinates of the currentRoom.
     * @param ms (MapState): List of MapState destinations.
     */

    private void setAllConnectorToMapState(DiscreteCoordinates coords, MapState ... ms){
        List<DiscreteCoordinates> roomAround = getAroundSpecificRoomLocations(coords.x, coords.y, placementMap, ms);
        for(int k = 0; k < roomAround.size(); ++k){
            String destination = "icrogue/level0" + roomAround.get(k).x + roomAround.get(k).y;
            ConnectorInRoom connector = calculateConnectorPos(coords, roomAround.get(k));
            setRoomConnector(coords, destination, connector);
        }
    }

    /**
     * Setting a locked connector of the currentRoom where destination is a MapState.
     * @param coords (DiscreteCoordinates): Coordinates of the currentRoom.
     * @param ms (MapState): MapState destination.
     * @param keyID (int): the keyID required to open the locked connector.
     */

    private void setAllLockedConnectorToMapState(DiscreteCoordinates coords, MapState ms, int keyID){
        List<DiscreteCoordinates> roomAround = getAroundSpecificRoomLocations(coords.x, coords.y, placementMap, ms);
        for(int k = 0; k < roomAround.size(); ++k){
            String destination = "icrogue/level0" + roomAround.get(k).x + roomAround.get(k).y;
            ConnectorInRoom connector = calculateConnectorPos(coords, roomAround.get(k));
            lockRoomConnector(coords, connector, keyID);
            setRoomConnectorDestination(coords, destination, connector);
        }
    }

    /**
     * Setting all connector of not restricted room.
     * Might be change if you add other locked Room.
     * @param coords (DiscreteCoordinates): Coordinates of the currentRoom.
     */
    private void setAllConnectorNotRestrictedRoom(DiscreteCoordinates coords){
        setAllConnectorToMapState(coords, MapState.EXPLORED);
        setAllLockedConnectorToMapState(coords, MapState.TURRET_ROOM, TURRET_ROOM_KEY_ID);
        setAllLockedConnectorToMapState(coords, MapState.BOSS_ROOM, BOSS_KEY_ID);

    }
}

