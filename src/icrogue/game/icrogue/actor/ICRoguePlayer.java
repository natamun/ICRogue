package icrogue.game.icrogue.actor;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.*;
import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.game.areagame.io.ResourcePath;
import icrogue.game.icrogue.ICRogueKeybinds;
import icrogue.game.icrogue.actor.friendlyNPC.NinjaPNJ;
import icrogue.game.icrogue.actor.items.Cherry;
import icrogue.game.icrogue.actor.items.Heart;
import icrogue.game.icrogue.actor.items.Key;
import icrogue.game.icrogue.actor.items.Weapon;
import icrogue.game.icrogue.handler.ICRogueInteractionHandler;
import icrogue.math.DiscreteCoordinates;
import icrogue.math.Vector;
import icrogue.window.Button;
import icrogue.window.Canvas;
import icrogue.window.Keyboard;
import static icrogue.game.icrogue.area.level0.Level0.BOSS_KEY_ID;
import static icrogue.game.icrogue.area.level0.Level0.TURRET_ROOM_KEY_ID;

import java.util.ArrayList;
import java.util.List;

public class ICRoguePlayer extends ICRogueActor implements Interactor, ICRogueKeybinds, ICRogueGraphics {

    //--------------------------Player constants------------------------
    private final static double DIALOG_DISPLAY_DELAY = 0.25;
    private final static double INVULNERABILITY_COOLDOWN = 1;
    private final static int MOVE_DURATION = 8;
    private final static int SPRINT_DURATION = 4;


    //--------------------------Player attributs------------------------

    //Because Dark Lord need to know the max health of the player (to make him one shot player),
    // we make this attribut public static.
    public final static int PLAYER_MAX_HEALTH = 8;
    private static int health = PLAYER_MAX_HEALTH;
    private final List<Integer> keyList;
    private final List<Weapon> equipedWeapon;
    private static int moveSpeed = MOVE_DURATION;

    //--------------------------Drawable attributs----------------------
    private final Sprite[][] zeldaPlayer;
    private final Animation[] animateZeldaPlayer;
    private final Animation[] animateZeldaPlayerUsingFireStaff;
    private final Animation[] animateZeldaPlayerUsingWaterStaff;


    //--------------------------Player interactions--------------------
    private boolean connectorInteraction;
    private Connector currentConnector;
    private Boolean displayDialog;
    private int currentWeaponID;
    private Weapon currentWeapon;
    private int nextWeaponPOS;


    //--------------------------Other-----------------------------------
    private double dialogCoolDown;
    private double weaponCoolDown;
    private static double invulnerabilityCoolDown;
    private final Keyboard keyboard = getOwnerArea().getKeyboard();

    //------------------------------------------------------------------

    public ICRoguePlayer(Area area, Orientation orientation, DiscreteCoordinates position) {
        super(area, orientation, position);
        setInteractionHandler(new ICRoguePlayerInteractionHandler());
        keyList = new ArrayList<>();
        equipedWeapon = new ArrayList<>();
        currentWeaponID = 000;
        displayDialog = false;

        //Initialisation of Sprite and animation

        Orientation[] order = {Orientation.UP,Orientation.RIGHT,Orientation.DOWN,Orientation.LEFT};
        Vector anchor = new Vector(.10f,-.15f);
        zeldaPlayer = Sprite.extractSprites("zelda/player",4,.75f,1.5f,this,16,32,anchor,order);
        Sprite [][] zeldaPlayerUsingFireStaff = Sprite.extractSprites("zelda/player.staff_fire",4, 1.5f, 1.5f, this, 32, 32,anchor, order);
        Sprite [][] zeldaPlayerUsingWaterStaff = Sprite.extractSprites("zelda/player.staff_water",4, 1.5f, 1.5f, this, 32, 32,anchor, order);

        animateZeldaPlayer = Animation.createAnimations(moveSpeed /4,zeldaPlayer);
        animateZeldaPlayerUsingFireStaff = Animation.createAnimations(2, zeldaPlayerUsingFireStaff);
        animateZeldaPlayerUsingWaterStaff = Animation.createAnimations(2, zeldaPlayerUsingWaterStaff);

    }

    //--------------------------Move---------------------------------

    private void moveIfPressed(Orientation orientation, Button b){
        if(b.isDown()) {
            if (!isDisplacementOccurs() && orientation == getOrientation()) {
                orientate(orientation);
                move(moveSpeed);
            }else{
                orientate(orientation);
            }
        }
    }

    private void move(){
        moveIfPressed(Orientation.LEFT, keyboard.get(LEFT));
        moveIfPressed(Orientation.UP, keyboard.get(UP));
        moveIfPressed(Orientation.RIGHT, keyboard.get(RIGHT));
        moveIfPressed(Orientation.DOWN, keyboard.get(DOWN));
    }

    private void sprint(){
        if(keyboard.get(SPRINT).isDown()){
            moveSpeed = SPRINT_DURATION;
        }else{
            moveSpeed = MOVE_DURATION;
        }
    }

    //--------------------------Weapon-----------------------------

    private void useWeapon(){
        if(currentWeapon != null && keyboard.get(USE_WEAPON).isDown() && weaponCoolDown <= 0 && !isDisplacementOccurs()){
            getOwnerArea().registerActor(currentWeapon.getWeaponProjectiles(getOwnerArea(),getOrientation(),getCellInFrontOfActor()));
            weaponCoolDown = currentWeapon.getWeaponCoolDown();
        }
    }

    private void switchWeapon(){
        if(equipedWeapon.size() > 1){
            if(keyboard.get(SWITCH_WEAPON).isPressed()){
                if(nextWeaponPOS == equipedWeapon.size()){
                    nextWeaponPOS = 0;
                }
                currentWeapon = equipedWeapon.get(nextWeaponPOS);
                currentWeaponID = currentWeapon.getWeaponID();
                currentGearGraph.setName(ResourcePath.getSprite(currentWeapon.getGearIconPath()));
                ++nextWeaponPOS;
            }
        }
    }


    public static void damagePlayer(int x){
        if(invulnerabilityCoolDown <= 0){
            health -= x;
            invulnerabilityCoolDown = INVULNERABILITY_COOLDOWN;
        }
    }

    public boolean gameOver(){ return health <= 0; }

    //--------------------------Drawable-------------------------------

    /**
     * Drawing the player in certains conditions.
     * If he's moving, we draw the animatedPlayer
     *
     * If he uses weapon, we draw the animatedPlayerUsingAWeapon, depending on the currentWeaponID.
     * ID 000 means he did not have weapon equiped.
     *
     * Else, we draw the sprite of the player.
     *
     * @param canvas (Canvas): the canvas.
     */

    private void playerDraw(Canvas canvas){
        Orientation orientation = getOrientation();
        if(isDisplacementOccurs()) {
            animationDraw(animateZeldaPlayer, orientation, canvas);
        }else if(currentWeaponID != 000 && keyboard.get(USE_WEAPON).isDown()){
            switch(currentWeaponID){
                case 111 -> animationDraw(animateZeldaPlayerUsingFireStaff, orientation, canvas);
                case 222 -> animationDraw(animateZeldaPlayerUsingWaterStaff, orientation, canvas);
            }
        }else{
            noAnimationDraw(zeldaPlayer,orientation, canvas);
        }
    }

    private void displayDialog(){
        dialogCoolDown = DIALOG_DISPLAY_DELAY;
        displayDialog = true;
    }

    /**
     * Drawing the dialog graph and the text associated.
     *
     * He will disappear when INTERACT is pressed and the cool down is done.
     *
     * Because we use same keybinds to make him disappear that when he appears (when player interact),
     * we have to set a cool down, so he does not disappear instantly.
     *
     * @param canvas (Canvas): the canvas.
     */
    private void dialogDraw(Canvas canvas){
        if(displayDialog){
            dialogGraph.draw(canvas);
            dialogText.draw(canvas);
            if(keyboard.get(INTERACT).isPressed() && dialogCoolDown <= 0){
                displayDialog = false;

            }
        }
    }

    private void gearDraw(Canvas canvas){
        gearGraph.draw(canvas);
        if(currentWeapon != null){
            currentGearGraph.draw(canvas);
        }
    }

    private void healthDisplayDraw(Canvas canvas){
        int fullHearts = health / 2;
        int halfHearts = health % 2;
        Vector anchor = new Vector(0,10);
        for(int i = 0; i < fullHearts; ++i){
            hearthDisplay[2].draw(canvas);
            hearthDisplay[2].setAnchor(anchor);
            anchor = anchor.add(1,0);

        }
        if(halfHearts == 1){
            hearthDisplay[1].draw(canvas);
            hearthDisplay[1].setAnchor(anchor);
            anchor = anchor.add(1,0);
        }
        for (int i = 0; i < PLAYER_MAX_HEALTH /2 - fullHearts - halfHearts; ++i) {
            hearthDisplay[0].draw(canvas);
            hearthDisplay[0].setAnchor(anchor);
            anchor = anchor.add(1,0);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        playerDraw(canvas);
        gearDraw(canvas);
        dialogDraw(canvas);
        healthDisplayDraw(canvas);
    }

    //--------------------------Update---------------------------------

    private void updatePlayer(float deltaTime){
        weaponCoolDown -= deltaTime;
        dialogCoolDown -= deltaTime;
        invulnerabilityCoolDown -= deltaTime;
        updateOrientedAnimation(animateZeldaPlayer, deltaTime);
        updateOrientedAnimation(animateZeldaPlayerUsingFireStaff, deltaTime);
        updateOrientedAnimation(animateZeldaPlayerUsingWaterStaff, deltaTime);
    }

    @Override
    public void update(float deltaTime) {
        gameOver();
        updatePlayer(deltaTime);
        useWeapon();
        sprint();
        switchWeapon();
        move();
        super.update(deltaTime);
    }

    //--------------Methods ta manage connector interactions-----------

    public boolean getConnectorInteraction(){
        return connectorInteraction;
    }
    public void resetConnectorInteraction(){connectorInteraction = false;}
    public Connector getCurrentConnector(){
        return currentConnector;
    }

    //--------------------------Player interactions--------------------

    private class ICRoguePlayerInteractionHandler extends ICRogueActorInteractionHandler {
        @Override
        public void interactWith(NinjaPNJ ninjaPNJ, boolean wantsViewInteraction){
            if (keyboard.get(INTERACT).isPressed()){
                ninjaPNJ.interact();
                dialogText.setText(ninjaPNJ.getNinjaDialog());
                displayDialog();
            }
        }
        @Override
        public void interactWith(Cherry cherry, boolean wantsViewInteraction){
            cherry.collect();
            health += 1;
        }
        @Override
        public void interactWith(Heart heart, boolean wantsViewInteraction){
            if(PLAYER_MAX_HEALTH - health >= 2){
                heart.collect();
                health += 2;
            }else if(PLAYER_MAX_HEALTH - health == 1){
                heart.collect();
                health += 1;
            }
        }
        @Override
        public void interactWith(Weapon weapon, boolean wantsViewInteraction){
            if (keyboard.get(INTERACT).isPressed()){
                weapon.collect();
                equipedWeapon.add(weapon);
                currentWeaponID = weapon.getWeaponID();
                currentWeapon = weapon;

                currentGearGraph.setName(ResourcePath.getSprite(weapon.getGearIconPath()));
                dialogText.setText(weapon.getCollectedText());
                displayDialog();
            }
        }
        @Override
        public void interactWith(Key key, boolean wantsViewInteraction){
            if (key.getKeyID() == BOSS_KEY_ID){
                dialogText.setText("You found the boss room key !");
                displayDialog();
            }
            key.collect();
            keyList.add(key.getKeyID());
        }
        @Override
        public void interactWith(Connector connector, boolean wantsViewInteraction){
            if(connector.isOpen()){
                connectorInteraction = true;
                currentConnector = connector;
            }
            if(connector.isLocked() && keyboard.get(INTERACT).isPressed()){
                if(keyList.contains(connector.getKeyID())){
                    connector.openIt();
                }else{
                    if(connector.getKeyID() == BOSS_KEY_ID ){
                        dialogText.setText("You need a red key to open this door, it might be somewhere...");
                        displayDialog();
                    }
                    else if(connector.getKeyID() == TURRET_ROOM_KEY_ID){
                        dialogText.setText("You need a grey key to open this door, it might be somewhere...");
                        displayDialog();
                    }
                    else {
                        dialogText.setText("Specific key is required to open this door, it might be somewhere...");
                        displayDialog();
                    }
                }
            }else if(connector.isClosed() && keyboard.get(INTERACT).isPressed()){
                dialogText.setText("This door will stay close until the challenge is done !");
                displayDialog();
            }

        }
    }

    @Override
    public boolean takeCellSpace() {
        return true;
    }

    @Override
    public boolean isCellInteractable() {
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

    @Override
    public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {
        ((ICRogueInteractionHandler) v).interactWith(this , isCellInteraction);
    }
}