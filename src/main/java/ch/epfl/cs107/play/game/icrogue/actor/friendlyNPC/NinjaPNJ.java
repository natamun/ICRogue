package ch.epfl.cs107.play.game.icrogue.actor.friendlyNPC;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.actor.items.Item;
import ch.epfl.cs107.play.game.icrogue.area.level0.rooms.Level0FireStaffRoom;
import ch.epfl.cs107.play.game.icrogue.area.level0.rooms.Level0WaterStaffRoom;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.window.Canvas;

public class NinjaPNJ extends Item {
    //Sprite source :
    //https://www.deviantart.com/5qu3l3t0n/art/Pokemon-GBA-Ninja-Overwold-Sprite-771919482
    Animation animatedVanish;
    Sprite ninja;
    private boolean interact;
    private double vanishDuration = 0.3;

    /**
     * Creates an instance of a NinjaPNJ, those will act like an item, disappearing when player interact with.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     */
    public NinjaPNJ(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        ninja = new Sprite("icrogue/ninja_pnj", 1f,1.3333f, this, new RegionOfInterest(0,0,32,48));
        Sprite[] vanish = Sprite.extractSprites("zelda/vanish",
                7,1f,1f,this,32,32);
        animatedVanish = new Animation(1, vanish,true);

    }

    /**
     * interacting with the NinjaPNJ, he will disappear (but not instantly), that's why we're "redefining" collect.
     */
    public void interact(){ interact = true;}

    /**
     * getter to know value of Ninja interact.
     * @return interact
     */
    public boolean isInteract(){ return interact;}

    /**
     * Returns a specific dialog depending on the  class of the room the ninja is in.
     * @return (String) a dialog.
     */
    public String getNinjaDialog(){
        Class<? extends Area> a = getOwnerArea().getClass();
        if(a == Level0FireStaffRoom.class){
            return "Don't burn yourself! This weapon was forged in the heart of a star!";
        }else if(a == Level0WaterStaffRoom.class){
            return "It will surely be useful later...";
        }else{
            return "Hey";
        }
    }

    /**
     * updates the vanishDuration
     * @param deltaTime
     */
    private void vanishDuration(float deltaTime){
        vanishDuration -= deltaTime;
    }

    /**
     * Drawing the ninja, if player interact with, draw vanish while vanishDuration is positif.
     */
    @Override
    public void draw(Canvas canvas){
        if(!isInteract()){
            ninja.draw(canvas);
        }else if(vanishDuration > 0){
            animatedVanish.draw(canvas);
        }
    }

    /**
     * Updating the ninja, if player interact with, we start the animation of vanish, and decreasing the duration of it.
     * If vanish is done, we collect the ninja
     */

    @Override
    public void update(float deltaTime){
        super.update(deltaTime);
        if(isInteract()){
            vanishDuration(deltaTime);
            animatedVanish.update(deltaTime);
        }
        if(vanishDuration < 0){
            collect();
        }
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
    public void acceptInteraction(AreaInteractionVisitor v, boolean wantsViewInteraction){
        if(!isCollected()){
            ((ICRogueInteractionHandler) v).interactWith(this , wantsViewInteraction);
        }
    }
}
