package ch.epfl.cs107.play.game.icrogue.area;

import ch.epfl.cs107.play.math.DiscreteCoordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


abstract public class Level {
    private ICRogueRoom[][] map;
    private DiscreteCoordinates roomSpawn;
    private DiscreteCoordinates bossRoomLocation;
    private String startPosition;
    private int height;
    private int width;
    private int nbRooms;
    private Random myRoomGenerator = new Random();

    protected enum MapState {
        NULL, // Empty space
        PLACED, // The room has been placed but not yet explored by the room placement algorithm
        EXPLORED, // the room has been placed and explored by the algorithm
        TURRET_ROOM, // the room is a turret room
        WEAKNESS_WEAPON_BOSS_ROOM, // the room contains the weakness weapon boss
        BOSS_KEY_ROOM,
        BOSS_ROOM; // The room is a boss room

        @Override
        public String toString() {
            return Integer.toString(ordinal());
        }
    }

    /**
     * Create a Level, depending on some parameters.
     *
     * @param randomMap (boolean): if the map is random or not.
     * @param roomSpawn (DiscreteCoordinates): the coordinate where the player start.
     * @param roomDistributions (int[]): the distributions of all room.
     * @param width (int): the width of the map.
     * @param height (int): the height of the map.
     */

    public Level(boolean randomMap, DiscreteCoordinates roomSpawn,
                 int[] roomDistributions, int width, int height) {
        if (!randomMap) {
            this.roomSpawn = roomSpawn;
            this.height = height;
            this.width = width;
            map = new ICRogueRoom[width][height];
        } else {
            for (Integer rd : roomDistributions) {
                nbRooms += rd;
            }
            this.height = nbRooms;
            this.width = nbRooms;
            map = new ICRogueRoom[nbRooms][nbRooms];
        }
    }

    protected void setRoom(DiscreteCoordinates coords, ICRogueRoom room) {
        map[coords.x][coords.y] = room;
    }

    protected void setRoomConnectorDestination(DiscreteCoordinates coords, String destination,
                                               ConnectorInRoom connector) {
        map[coords.x][coords.y].connectorsList.get(connector.getIndex()).setDestination(destination);
    }

    protected void setRoomConnector(DiscreteCoordinates coords, String destination,
                                    ConnectorInRoom connector) {
        map[coords.x][coords.y].connectorsList.get(connector.getIndex()).setDestination(destination);
        map[coords.x][coords.y].connectorsList.get(connector.getIndex()).closeIt();
    }

    protected void lockRoomConnector(DiscreteCoordinates coords, ConnectorInRoom connector, int keyId) {
        map[coords.x][coords.y].connectorsList.get(connector.getIndex()).setKeyId(keyId);
        map[coords.x][coords.y].connectorsList.get(connector.getIndex()).lockIt();
    }

    protected void setStartPosition(DiscreteCoordinates coords) {
        startPosition = map[coords.x][coords.y].getTitle();
        roomSpawn = coords;
    }
    protected void setBossRoomLocation(DiscreteCoordinates coords){ bossRoomLocation = coords;}

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return width;
    }

    public ICRogueRoom[][] getMap() {
        return map;
    }

    public DiscreteCoordinates getRoomSpawn() {
        return roomSpawn;
    }

    public String getStartPosition(){return startPosition;}

    public DiscreteCoordinates getBossRoomLocation(){
        return bossRoomLocation;
    }

    /**
     * Generating a random placement map with some restrictions.
     *
     * @return a random placement of MapState
     */

    protected MapState[][] generateRandomRoomPlacement() {
        //Comme le programme possède de très rare cas où il génère une map inconfortable produisant une erreur,
        //comme une map qui se génère en escargot, dans ce cas-là on ignore l'exception et on relance la génération.
        while(true) {
            try {

                // Initialiser la carte des placements en marquant toutes les positions comme étant vides (MapState.NULL)
                MapState[][] placementMap = new MapState[nbRooms][nbRooms];
                for (int i = 0; i < nbRooms; i++) {
                    for (int j = 0; j < nbRooms; j++) {
                        placementMap[i][j] = MapState.NULL;
                    }
                }

                // Marquer la salle au centre de la carte comme placée (MapState.PLACED)
                int centerRoom = nbRooms / 2;
                placementMap[centerRoom][centerRoom] = MapState.PLACED;

                // Répéter le processus de placement des salles jusqu'à ce que toutes les salles soient placées
                // On a déjà placé une room au centre et on va placer 2 autres rooms qui nécessite une séquence
                int roomsToPlace = nbRooms - 3;
                while (roomsToPlace > 0) {
                    // Parcourir toutes les salles placées, mais non explorées
                    for (int i = 0; i < nbRooms; i++) {
                        for (int j = 0; j < nbRooms; j++) {
                            if (placementMap[i][j] == MapState.PLACED) {
                                // Calculer le nombre d'emplacements libres autour de cette salle
                                int freeSlots = getAroundSpecificRoomLocations(i, j, placementMap, MapState.NULL).size();

                                // Tirer au hasard un nombre maximal de salles à placer (au plus le minimum entre roomsToPlace et freeSlots)
                                int maxRoomsToPlace = Math.min(roomsToPlace, freeSlots);
                                int roomsToActuallyPlace = myRoomGenerator.nextInt(1, (maxRoomsToPlace) + 1);

                                // Placer ces salles au hasard dans les emplacements libres disponibles
                                List<DiscreteCoordinates> freeSlotLocations;
                                freeSlotLocations = getAroundSpecificRoomLocations(i, j, placementMap,MapState.NULL);
                                Collections.shuffle(freeSlotLocations);
                                for (int k = 0; k < roomsToActuallyPlace; k++) {
                                    DiscreteCoordinates freeSlot = freeSlotLocations.get(k);
                                    placementMap[freeSlot.x][freeSlot.y] = MapState.PLACED;
                                    roomsToPlace--;
                                    if (roomsToPlace == 0) {
                                        break;
                                    }
                                }
                                // Marquer la salle courante comme explorée
                                placementMap[i][j] = MapState.EXPLORED;
                            }
                        }
                    }
                }
                //setting a room sequence, (adding some restrictions).
                //The player will not reach boss key room before he did turret room...
                placeRoomSequence(placementMap, MapState.BOSS_ROOM);
                placeRoomSequence(placementMap, MapState.TURRET_ROOM, MapState.WEAKNESS_WEAPON_BOSS_ROOM, MapState.BOSS_KEY_ROOM);
                for (int i = 0; i < nbRooms; i++) {
                    for (int j = 0; j < nbRooms; j++) {
                        if (placementMap[i][j] == MapState.PLACED) {
                            placementMap[i][j] = MapState.EXPLORED;
                        }
                    }
                }

                return placementMap;
            } catch (Exception e) {}
        }
    }

    /**
     * Getter for the coordinate of some Map State around the current map.
     *
     * @param x (int): coordinates x of the current room.
     * @param y (int): coordinates y of the current room.
     * @param placementMap (MapState[][]): current placement map.
     * @param ms (MapState) : a list of Map State we want to know the coordinate around the current room.
     *
     * @return a list of coordinates of some mapState asked
     */
    protected List<DiscreteCoordinates> getAroundSpecificRoomLocations(int x, int y, MapState[][] placementMap, MapState... ms) {
        List<DiscreteCoordinates> specificSlotLocations = new ArrayList<>();
        for(int i = 0; i < ms.length; ++i){
           // Ajouter l'emplacement en haut
           if (y > 0 && placementMap[x][y - 1] == ms[i]) {
               specificSlotLocations.add(new DiscreteCoordinates(x, y - 1));
           }

           // Ajouter l'emplacement à droite
           if (x < placementMap.length - 1 && placementMap[x + 1][y] == ms[i]) {
               specificSlotLocations.add(new DiscreteCoordinates(x + 1, y));
           }

           // Ajouter l'emplacement en bas
           if (y < placementMap[x].length - 1 && placementMap[x][y + 1] == ms[i]) {
               specificSlotLocations.add(new DiscreteCoordinates(x, y + 1));
           }

           // Ajouter l'emplacement à gauche
           if (x > 0 && placementMap[x - 1][y] == ms[i]) {
               specificSlotLocations.add(new DiscreteCoordinates(x - 1, y));
           }
        }

        return specificSlotLocations;
    }

    /**
     * Getter of all coordinate of a Map State.
     *
     * @param placementMap (MapState[][]): current placement map.
     * @param ms (MapState) : the Map State we want to know all coordinates.
     *
     * @return a list of all coordinates of the Map State asked.
     */

    private List<DiscreteCoordinates> getAllSpecificRoomLocations(MapState[][] placementMap, MapState ms) {
        List<DiscreteCoordinates> placedRoomLocations = new ArrayList<>();

        for (int i = 0; i < placementMap.length; i++) {
            for (int j = 0; j < placementMap[i].length; j++) {
                if (placementMap[i][j] == ms) {
                    placedRoomLocations.add(new DiscreteCoordinates(i, j));
                }
            }
        }

        return placedRoomLocations;
    }

    /**
     * Placing a room sequence on the mapState, depending on Map State PLACED.
     * We use PLACED as start position because we know this state have free room around.
     *
     * @param placementMap (MapState[][]): current placement map.
     * @param roomState (MapState) : placing a sequence of MapState in the placementMap.
     *
     * @return a new MapState with the room sequence we asked.
     */

    private MapState[][] placeRoomSequence(MapState[][] placementMap, MapState ... roomState){
        //Getting all room locations.
        List<DiscreteCoordinates> placedRoomLocations = getAllSpecificRoomLocations(placementMap, MapState.PLACED);

        //Shuffle it to keep random concept and get the first object.
        Collections.shuffle(placedRoomLocations);
        DiscreteCoordinates aRandomPlacedRoom = placedRoomLocations.get(0);
        placedRoomLocations.remove(0);

        //Setting the roomState we wanted on arguments.
        placementMap[aRandomPlacedRoom.x][aRandomPlacedRoom.y] = roomState[0];

        //In case we asked a sequenced placement, we set it, while always keeping random concept.
        if(roomState.length > 1){
            List<DiscreteCoordinates> freeSlotLocations;

            for(int i = 1; i < roomState.length; ++i){
                freeSlotLocations = getAroundSpecificRoomLocations(aRandomPlacedRoom.x,aRandomPlacedRoom.y, placementMap, MapState.NULL);
                Collections.shuffle(freeSlotLocations);
                aRandomPlacedRoom = freeSlotLocations.get(0);
                placementMap[aRandomPlacedRoom.x][aRandomPlacedRoom.y] = roomState[i];
            }
        }

        return placementMap;
    }

    protected void printMap(MapState [][] map) {
        System.out.println("Generated map:");
        System.out.print("  | ");
        for (int j = 0; j < map[0]. length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.print("--|-");
        for (int j = 0; j < map[0]. length; j++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}

