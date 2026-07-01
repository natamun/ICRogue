package icrogue;

import icrogue.engine.game.areagame.AreaBehavior;
import icrogue.engine.game.areagame.actor.Interactable;
import icrogue.engine.game.areagame.handler.AreaInteractionVisitor;
import icrogue.handler.ICRogueInteractionHandler;
import icrogue.engine.window.Window;


/*
 * Author :     Natalino MUNARI
 * Date :       03.12.2022{
 */
public class ICRogueBehavior extends AreaBehavior {

    public enum ICRogueCellType{
        NONE(0,false), // Should never been used except in the toType method
        GROUND(-16777216, true), // traversable
        WALL(-14112955, false), // non traversable
        HOLE(-65536, true);

        final int type;
        final boolean isWalkable;

        ICRogueCellType(int type, boolean isWalkable){
            this.type = type;
            this.isWalkable = isWalkable;
        }

        public static ICRogueCellType toType(int type){
            for(ICRogueCellType ict : ICRogueCellType.values()){
                if(ict.type == type)
                    return ict;
            }
            // When you add a new color, you can print the int value here before assign it to a type
            System.out.println(type);
            return NONE;
        }
    }

    /**
     * Default ICRogueBehavior Constructor
     * @param window (Window), not null
     * @param name (String): Name of the Behavior, not null
     */
    public ICRogueBehavior(Window window, String name){
        super(window, name);
        int height = getHeight();
        int width = getWidth();
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width ; x++) {
                ICRogueCellType color = ICRogueCellType.toType(getRGB(height-1-y, x));
                setCell(x,y, new ICRogueBehavior.ICRogueCell(x,y,color));
            }
        }
    }

    /**
     * Cell adapted to the ICRogue game
     */
    public class ICRogueCell extends Cell {
        /// Type of the cell following the enum
        private final ICRogueCellType type;

        /**
         * Default ICRogueCell Constructor
         * @param x (int): x coordinate of the cell
         * @param y (int): y coordinate of the cell
         * @param type (ICRogueCellType), not null
         */
        public  ICRogueCell(int x, int y, ICRogueCellType type){
            super(x, y);
            this.type = type;
        }

        public ICRogueCellType getType() {
            return type;
        }

        @Override
        protected boolean canLeave(Interactable entity) {
            return true;
        }

        @Override
        protected boolean canEnter(Interactable entity) {
            boolean walkable = true;
            for(Interactable interactable : entities){
                if(interactable.takeCellSpace()){
                    walkable = false;
                }
            }
            return walkable&&type.isWalkable;

        }
        @Override
        public boolean isCellInteractable() {
            return true;
        }

        @Override
        public boolean isViewInteractable() {
            return false;
        }

        @Override
        public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {
            ((ICRogueInteractionHandler) v).interactWith(this , isCellInteraction);
        }

    }
}

