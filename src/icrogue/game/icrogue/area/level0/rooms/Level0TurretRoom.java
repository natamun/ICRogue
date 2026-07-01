package icrogue.game.icrogue.area.level0.rooms;

import icrogue.game.areagame.actor.Orientation;
import icrogue.game.icrogue.actor.enemies.Enemy;
import icrogue.game.icrogue.actor.enemies.Turret;
import icrogue.math.DiscreteCoordinates;
import java.util.ArrayList;
import java.util.Random;

public class Level0TurretRoom extends Level0EnemyRoom{
    private Random ram = new Random();
    private ArrayList<Enemy> enemyList = new ArrayList<>();

    /**
     * Turret Room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0TurretRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
        generateTurretsPosition();
        setEnemies(enemyList);
    }

    /**
     * Generates a random number of turrets as well as a random position and calls the generate function to place them.
     */
    public void generateTurretsPosition() {
        int i = ram.nextInt(2,6);
        for (int k = 0; k < i; k++) {
            int x = ram.nextInt(1, 9);
            int y = ram.nextInt(1, 9);
            generate(x, y);
        }
    }

    /**
     * Specifies the shooting directions of the turret and places adds the turret to the list of enemies.
     * @param x (int) the x coordinate of the turret.
     * @param y(int) the y coordinate of the turret.
     */
    public void generate(int x, int y){
        if (x ==1 && y ==1){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.UP, Orientation.RIGHT));
        }
        else if (x ==1 && y == 8){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.DOWN, Orientation.RIGHT));
        }
        else if (x ==8 && y == 8){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.DOWN, Orientation.LEFT));
        }
        else if (x ==8 && y == 1){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.UP, Orientation.LEFT));
        }
        else if (x ==1){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.UP, Orientation.DOWN, Orientation.RIGHT));
        }
        else if (x ==8){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.UP, Orientation.DOWN, Orientation.LEFT));
        }
        else if (y ==1){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.UP, Orientation.RIGHT, Orientation.LEFT));
        }
        else if (y==8){
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.DOWN, Orientation.RIGHT, Orientation.LEFT));
        }
        else{
            enemyList.add(new Turret(this, Orientation.UP, new DiscreteCoordinates(x, y), Orientation.UP, Orientation.DOWN, Orientation.RIGHT, Orientation.LEFT));
        }
    }
}
