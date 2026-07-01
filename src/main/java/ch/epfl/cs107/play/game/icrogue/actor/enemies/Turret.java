package ch.epfl.cs107.play.game.icrogue.actor.enemies;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.icrogue.actor.ICRoguePlayer;
import ch.epfl.cs107.play.game.icrogue.actor.projectiles.Arrow;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;

import java.util.List;

public class Turret extends Enemy {
    private final int SHOOTING_COOLDOWN = 50;
    private final static int TURRET_CONTACT_DAMAGE = 2;
    private final int TURRET_HEALTH = 6;
    private Orientation[] arrowDirection;
    private int turretCooldown = 10;

    /**
     * Creates an instance of a Turret.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     * @param arrowDirection (Orientation): all directions turret will shoot an arrow.
     */
    public Turret(Area area, Orientation orientation, DiscreteCoordinates position, Orientation ... arrowDirection) {
        super(area, orientation, position, TURRET_CONTACT_DAMAGE);
        this.arrowDirection = arrowDirection;
        setInteractionHandler(new TurretHandler());
        setHealth(TURRET_HEALTH);
        setSprite(new Sprite("icrogue/static_npc", 1.5f, 1.5f,
                this , null , new Vector(-0.25f, 0)));
    }

    /**
     * Shoots arrows if the cool down is equal to 0, depending on the arrowDirection gave on constructor.
     */
    private void shootArrow() {
        if (turretCooldown == 0) {
            for (int i = 0; i < arrowDirection.length; i++){
                switch (arrowDirection[i]){
                    case UP -> getOwnerArea().registerActor(new Arrow(getOwnerArea(), Orientation.UP, getCurrentMainCellCoordinates().up()));
                    case DOWN -> getOwnerArea().registerActor(new Arrow(getOwnerArea(), Orientation.DOWN, getCurrentMainCellCoordinates().down()));
                    case LEFT -> getOwnerArea().registerActor(new Arrow(getOwnerArea(), Orientation.LEFT, getCurrentMainCellCoordinates().left()));
                    case RIGHT -> getOwnerArea().registerActor(new Arrow(getOwnerArea(), Orientation.RIGHT, getCurrentMainCellCoordinates().right()));
                }
            }
            turretCooldown = SHOOTING_COOLDOWN;
        }
    }

    /**
     * updates the cool down.
     * @param deltaTime
     */
    private void turretCooldownManager(float deltaTime){
        if(turretCooldown > 0){
            turretCooldown -= deltaTime;
        }else{
            turretCooldown = 0;
        }
    }
    @Override
    public void update(float deltaTime) {
        turretCooldownManager(deltaTime);
        super.update(deltaTime);
    }
    @Override
    public List<DiscreteCoordinates> getFieldOfViewCells(){
        //field of view will be all the cells the same lane as the enemy.
        return getAllCellInLineOfActor();
    }

    //--------------------------Turret interactions------------------

    private class TurretHandler extends EnemyHandler {
        @Override
        public void interactWith(ICRoguePlayer player, boolean wantsViewInteraction){
            //damages the player if it stands in front of it or shoots arrow if it is in its lane.
            if((getCurrentMainCellCoordinates().getNeighbours()).contains(player.getCurrentCells().get(0))) {
                player.damagePlayer(TURRET_CONTACT_DAMAGE);
            }else{
                shootArrow();
            }
        }
    }

}
