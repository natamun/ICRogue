package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.icrogue.actor.enemies.Enemy;
import ch.epfl.cs107.play.game.icrogue.actor.items.Heart;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import java.util.ArrayList;
import java.util.List;

abstract public class Level0EnemyRoom extends Level0Room {
    private List<Enemy> enemyList;
    private List<Enemy> removeEnemyFromList = new ArrayList<Enemy>();
    /**
     * Enemy Room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0EnemyRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
    }

    /**
     * Sets the enemies of the room.
     * @param Enemies (List): the list of enemies.
     */
    protected void setEnemies(List<Enemy> Enemies){
        enemyList = Enemies;
    }

    @Override
    public boolean isOn() {
        //return true if all enemies are dead and player walked in the room.
        return (super.isOn() && enemyList.size() == 0);
    }

    /**
     * Updates the list of current enemies and adds the dead enemies to a list of dead enemies
     */
    public void ListUpdate(){
        for(Enemy c : enemyList){
            if (c.isDead() == true && removeEnemyFromList.contains(c) == false ){
                removeEnemyFromList.add(c);
                registerActor(new Heart(this, Orientation.UP, new DiscreteCoordinates(5,5)));
            }
        }

        for(Enemy c : removeEnemyFromList){
            enemyList.remove(c);
        }
    }

    @Override
    public void update(float deltaTime) {
        ///updates the list of enemies
        ListUpdate();
        super.update(deltaTime);
    }

    @Override
    protected void createArea() {
        //Creates the room and places the enemies in the room.
        super.createArea();
        for(Enemy c : enemyList){
            c.enterArea(this, new DiscreteCoordinates((int) c.getPosition().x, (int) c.getPosition().y));
        }
    }
}
