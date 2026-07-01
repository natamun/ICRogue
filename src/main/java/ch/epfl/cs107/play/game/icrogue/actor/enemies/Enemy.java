package ch.epfl.cs107.play.game.icrogue.actor.enemies;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Interactor;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.actor.ICRogueActor;
import ch.epfl.cs107.play.game.icrogue.actor.ICRoguePlayer;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import java.util.Collections;
import java.util.List;


abstract  public class Enemy extends ICRogueActor implements Interactor {
    private boolean isDead;
    private int health;
    private final static int DEFAULT_CONTACT_DAMAGE = 1;
    private int contactDamage;

    /**
     * Constructor of an enemy with specific contactDamage.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     * @param contactDamage (int): the damage the ennemy will do when player is in contact with it.
     */
    public Enemy(Area area, Orientation orientation, DiscreteCoordinates position, int contactDamage) {
        super(area, orientation, position);
        this.contactDamage = contactDamage;
        setInteractionHandler(new EnemyHandler());
    }

    /**
     * Constructor of an enemy with default contactDamage.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public Enemy(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        this.contactDamage = DEFAULT_CONTACT_DAMAGE;
        setInteractionHandler(new EnemyHandler());
    }

    /**
     * Public method used to damage an enemy.
     * @param damage the damage done on the enemy.
     */
    public void damageEnemy(int damage) {
        health -= damage;
        if(health <= 0){
            die();
            leaveArea();
        }
    }

    //--------------------------Getters & setters----------------------
    public boolean isDead(){ return isDead;}
    public void die(){ isDead = true;}
    protected void setHealth(int health){
        this.health = health;
    }

    //--------------------------Enemy interactions-------------------
    @Override
    public List<DiscreteCoordinates> getFieldOfViewCells(){
        return Collections.singletonList(getCurrentMainCellCoordinates().jump(getOrientation().toVector()));
    }

    /**
     * this interaction handler sets the default interactions of enemy.
     */

    protected class EnemyHandler extends ICRogueActorInteractionHandler {
        public void interactWith(ICRoguePlayer player, boolean wantsViewInteraction){
            //damages the player when enemy interacts with him
            player.damagePlayer(contactDamage);
        }
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {
        ((ICRogueInteractionHandler) v).interactWith(this , isCellInteraction);
    }

    @Override
    public boolean takeCellSpace() {
        return true;
    }
    @Override
    public boolean isViewInteractable() {
        return true;
    }
    @Override
    public boolean wantsCellInteraction() {
        return true;
    }
    @Override
    public boolean wantsViewInteraction() {
        return true;
    }

}




