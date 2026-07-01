package ch.epfl.cs107.play.game.icrogue.actor.enemies;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.*;
import ch.epfl.cs107.play.game.icrogue.actor.ICRoguePlayer;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import java.util.List;
import java.util.Random;

public class FlameSkull extends Enemy{
    private DiscreteCoordinates playerPosition = new DiscreteCoordinates(0,0);
    private final static int CONTACT_DAMAGE = 1;
    private Animation[] animatedFlameSkull;
    private int moveCoolDown;

    /**
     * Creates an instance of a FlameSkull.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public FlameSkull(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        setInteractionHandler(new FlameSkullHandler());
        setHealth(1);

        Orientation[] order = {Orientation.DOWN,Orientation.LEFT,Orientation.UP,Orientation.RIGHT};
        Sprite[][] flameSkull = Sprite.extractSprites("zelda/flameskull",
                3, 1.5f, 1.5f, this, 32, 32, new Vector(-.25f,0),order);
        animatedFlameSkull = Animation.createAnimations(2, flameSkull);
    }

    /**
     * Calculates the orientation  of the flame skull that he needs to reach player.
     * @return the orientation of the flame Skull.
     */
    private Orientation calculOrientation(){
        int dx = playerPosition.x - getCurrentMainCellCoordinates().x;
        int dy = playerPosition.y - getCurrentMainCellCoordinates().y;
        if(dx > 0){
            return Orientation.RIGHT;
        }else if(dx < 0){
            return Orientation.LEFT;
        }else if(dy > 0){
            return Orientation.UP;
        }else if(dy < 0){
            return Orientation.DOWN;
        }
        return Orientation.UP;
    }

    /**
     * Moves the flame skull.
     * @param deltaTime
     */
    private void flameSkullmove(float deltaTime){
        moveCoolDown -= deltaTime;
        if (moveCoolDown <= 0){
            int i = new Random().nextInt(0,4);
            orientate(calculOrientation());
            move(2);
            moveCoolDown = 12;
        }
    }


    @Override
    public void draw(Canvas canvas) {
        animationDraw(animatedFlameSkull, getOrientation(), canvas);
    }
    @Override
    public void update(float deltaTime) {
        updateOrientedAnimation(animatedFlameSkull, deltaTime);
        flameSkullmove(deltaTime);
        super.update(deltaTime);
    }

    /**
     * FlameSkull can see all inside the room.
     * @return all cell in the room.
     */
    @Override
    public List<DiscreteCoordinates> getFieldOfViewCells() {
        return getAllCellInRoom();
    }

    @Override
    public boolean takeCellSpace(){return false;}

    private class FlameSkullHandler extends EnemyHandler {
        @Override
        public void interactWith(ICRoguePlayer player, boolean wantsViewInteraction){

            playerPosition = player.getCurrentCells().get(0);
            if(getCurrentMainCellCoordinates().getNeighbours().contains(playerPosition)){
                player.damagePlayer(CONTACT_DAMAGE);
                leaveArea();
            }
        }
    }
}