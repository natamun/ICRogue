package icrogue;


import icrogue.engine.game.areagame.AreaGame;
import icrogue.engine.game.areagame.actor.Orientation;
import icrogue.MenuScreens.ICRogueGameOverMenu;
import icrogue.MenuScreens.ICRoguePauseMenu;
import icrogue.MenuScreens.ICRogueWonMenu;
import icrogue.actor.ICRoguePlayer;
import icrogue.area.ICRogueRoom;
import icrogue.area.level0.Level0;
import icrogue.area.level0.rooms.Level0Room;
import icrogue.engine.io.FileSystem;
import icrogue.engine.math.DiscreteCoordinates;
import icrogue.engine.window.Keyboard;
import icrogue.engine.window.Window;


public class ICRogue extends AreaGame implements ICRogueKeybinds {
    public enum MapMode { RANDOM, CLASSIC, DEBUG }

    public final static float CAMERA_SCALE_FACTOR = 13.f;
    private Level0Room currentArea;
    private Level0 level0;
    private ICRoguePlayer player;
    private final MapMode mapMode;

    private ICRogueRoom bossRoom;

    public ICRogue() {
        this(MapMode.RANDOM);
    }

    public ICRogue(MapMode mapMode) {
        this.mapMode = mapMode;
    }

    public String getTitle() {
        return "ICRogue";
    }
    private void initLevel(){
        switch (mapMode) {
            case CLASSIC -> level0 = new Level0(false, 1);
            case DEBUG -> level0 = new Level0(false, 0);
            default -> level0 = new Level0(true, 1);
        }

        DiscreteCoordinates spawnCoord = level0.getRoomSpawn();
        ICRogueRoom[][] map = level0.getMap();

        DiscreteCoordinates bossCord = level0.getBossRoomLocation();
        bossRoom = map[bossCord.x][bossCord.y];

        ICRogueRoom spawnRoom = map[spawnCoord.x][spawnCoord.y];
        for(int i = 0; i < level0.getWidth(); ++i){
            for(int j = 0; j < level0.getHeight(); ++j){
                if(map[i][j] != null){
                    addArea(map[i][j]);
                }
            }
        }
        setCurrentArea(level0.getStartPosition(), true);
        player = new ICRoguePlayer(spawnRoom, Orientation.UP,spawnRoom.getPlayerSpawnPosition());
        player.enterArea(spawnRoom, spawnRoom.getPlayerSpawnPosition());
    }

    public void resetGame(){
        Keyboard keyboard = getCurrentArea().getKeyboard();
        if(keyboard.get(RESET_GAME).isPressed()){
            initLevel();
        }
    }

    /**
     * pauses the game when PAUSE_GAME is pressed
     */
    private void pause(){
        Keyboard keyboard = getCurrentArea().getKeyboard();
        if(keyboard.get(PAUSE_GAME).isPressed()){
            if (super.isPaused()) {
                requestResume();
            }
            else {
                requestPause();
            }
        }
    }

    public void switchRoom(){
        if(player.getConnectorInteraction()){
            player.leaveArea();
            currentArea = (Level0Room) setCurrentArea(player.getCurrentConnector().getDestination(), false);
            player.enterArea(currentArea,player.getCurrentConnector().getSpawn());
            player.resetConnectorInteraction();
        }
    }

    public void endGame(){
        if (player.gameOver()){
            setPauseMenu(new ICRogueGameOverMenu());
            requestPause();
        }
        if(bossRoom.isOn()){
            setPauseMenu(new ICRogueWonMenu());
            requestPause();
        }
    }
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {

        if (super.begin(window, fileSystem)) {
            initLevel();
            return true;
        }
        setPauseMenu(new ICRoguePauseMenu());
        return false;
    }
    @Override
    public void update(float deltaTime) {
        pause();
        resetGame();
        switchRoom();
        endGame();
        super.update(deltaTime);
    }
    @Override
    public void end(){}
}