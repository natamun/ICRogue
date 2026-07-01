package ch.epfl.cs107.play.game.icrogue.actor.enemies;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.icrogue.ICRogueBehavior;
import ch.epfl.cs107.play.game.icrogue.actor.ICRogueGraphics;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import java.util.Random;

import static ch.epfl.cs107.play.game.icrogue.actor.ICRoguePlayer.PLAYER_MAX_HEALTH;

public class DarkLord extends Enemy implements ICRogueGraphics {

    //--------------------------Boss attributs-------------------------
    private final static int COOLDOWN = 40;
    private final static int MOVE_DURATION = 10;
    private final static int DARKLORD_HEALTH = 30;
    private static int bossHealth = DARKLORD_HEALTH;

    //--------------------------Drawable attributs---------------------
    Animation[] animatedDarkLord;
    Animation[] animatedDarkLordCasting;

    //--------------------------Other----------------------------------
    private int shootCooldown;
    private int moveCoolDown;

    /**
     * Creates an instance of a DarkLord
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public DarkLord(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position, PLAYER_MAX_HEALTH);
        setHealth(DARKLORD_HEALTH);
        setInteractionHandler(new DarkLordHandler());


        Orientation[] order = {Orientation.DOWN,Orientation.LEFT,Orientation.UP,Orientation.RIGHT};
        Sprite [][] darkLord = Sprite.extractSprites("zelda/darkLord",
                3, 1.5f, 1.5f, this, 32, 32, order);
        animatedDarkLord = Animation.createAnimations(2, darkLord);
        Sprite [][] darkLordCasting = Sprite.extractSprites("zelda/darkLord.spell",
                3, 1.5f, 1.5f, this, 32, 32, order);
        animatedDarkLordCasting = Animation.createAnimations(4, darkLordCasting);
    }

    //--------------------------DarkLord methods-----------------------

    /**
     * updates the moveCoolDown and moves when the cool down is done.
     * @param deltaTime
     */
    private void darkLordMove(float deltaTime){
        moveCoolDown -= deltaTime;
        if (moveCoolDown <= 0){
            int i = new Random().nextInt(0,4);
            orientate(Orientation.values()[i]);
            move(MOVE_DURATION);
            moveCoolDown = COOLDOWN;
        }
    }

    /**
     * updates the shooCooldown and casts a spell when the cool down is null.
     * @param deltaTime
     */
    private void castSpell(float deltaTime) {
        shootCooldown -= deltaTime;
        if (shootCooldown <= 0) {
            getOwnerArea().registerActor(new FlameSkull(getOwnerArea(), getOrientation(), getCellInFrontOfActor()));
            shootCooldown = COOLDOWN;
        }
    }

    /**
     * Overriding damageEnemy, so the boss act differently than ennemies, and we can get its own health
     * He will dash if he recieve damage, to make it harder to spam him !
     * @param damage
     */
    @Override
    public void damageEnemy(int damage) {
        bossHealth -= damage;
        move(2);
        if(bossHealth <= 0){
            die();
            leaveArea();
        }
    }

    /**
     * Display the current health boss
     * @param canvas
     */
    private void healthDisplayDraw(Canvas canvas){
        int fullHearts = bossHealth / 2;
        int halfHearts = bossHealth % 2;
        Vector anchor = new Vector(1.25f,-.5f);
        for(int i = 0; i < fullHearts; ++i){
            hearthDisplaySmall[2].draw(canvas);
            hearthDisplaySmall[2].setAnchor(anchor);
            anchor = anchor.add(.5f,0);

        }
        if(halfHearts == 1){
            hearthDisplaySmall[1].draw(canvas);
            hearthDisplaySmall[1].setAnchor(anchor);
            anchor = anchor.add(.5f,0);
        }
        for (int i = 0; i < DARKLORD_HEALTH / 2 - fullHearts - halfHearts; ++i) {
            hearthDisplaySmall[0].draw(canvas);
            hearthDisplaySmall[0].setAnchor(anchor);
            anchor = anchor.add(.5f,0);
        }
    }

    //--------------------------Drawable-------------------------------

    @Override
    public void draw(Canvas canvas) {
        if (isDisplacementOccurs()) {
            animationDraw(animatedDarkLord, getOrientation(), canvas);
        }else{
            animationDraw(animatedDarkLordCasting, getOrientation(), canvas);
        }
        healthDisplayDraw(canvas);
    }

    //--------------------------Update---------------------------------

    @Override
    public void update(float deltaTime) {
        updateOrientedAnimation(animatedDarkLord, deltaTime);
        updateOrientedAnimation(animatedDarkLordCasting, deltaTime);
        darkLordMove(deltaTime);
        castSpell(deltaTime);
        super.update(deltaTime);

    }

    //--------------------------DarkLord interaction-------------------
    private class DarkLordHandler extends EnemyHandler{
        @Override
        public void interactWith(ICRogueBehavior.ICRogueCell Cell, boolean wantsViewInteraction){
            //Interaction between the boss and a cell, orientate opposite if he looks a wall.
            if(Cell.getType() == ICRogueBehavior.ICRogueCellType.WALL ||  Cell.getType() == ICRogueBehavior.ICRogueCellType.HOLE ){
                orientate(getOrientation().opposite());
            }
        }
    }
}

