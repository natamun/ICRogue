package ch.epfl.cs107.play.game.icrogue.actor.items;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icrogue.handler.ICRogueInteractionHandler;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

abstract public class Weapon extends Item implements PlayerUsingWeapon {
    private int weaponID;
    private String collectedText;
    private String gearIconPath;
    private double weaponCoolDown = 1;

    /**
     * Constructor of a weapon.
     * @param area (Area): the area containing the instance.
     * @param orientation (Orientation): the orientation of the instance.
     * @param position (DiscreteCoordinates): the position of the instance.
     * @param weaponID (int) the  id of the weapon.
     */
    public Weapon(Area area, Orientation orientation, DiscreteCoordinates position, int weaponID) {
        super(area, orientation, position);
        this.weaponID = weaponID;
    }

    protected void setCollectedText(String collectedText) {
        this.collectedText = collectedText;
    }
    public String getCollectedText(){return collectedText;}
    protected void setGearIconPath(String gearIconPath) {
        this.gearIconPath = gearIconPath;
    }
    public String getGearIconPath() {
        return gearIconPath;
    }
    protected void setWeaponCoolDown(double wcd){ weaponCoolDown = wcd;}
    public double getWeaponCoolDown(){ return weaponCoolDown;}
    public int getWeaponID(){return weaponID;}

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
