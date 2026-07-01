package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.enemies.DarkLord;
import ch.epfl.cs107.play.game.icrogue.actor.enemies.Enemy;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import java.util.ArrayList;
import java.util.Arrays;

public class Level0BossRoom extends Level0EnemyRoom{

    /**
     * Level0BossRoom constructor.
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0BossRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>(Arrays.asList(
                new DarkLord(this, Orientation.UP, new DiscreteCoordinates(5,5))));
        setEnemies(enemyList);

    }
}
