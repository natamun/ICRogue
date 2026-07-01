package ch.epfl.cs107.play.game.icrogue.area.level0.rooms;

import ch.epfl.cs107.play.game.icrogue.actor.items.Item;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import java.util.ArrayList;
import java.util.List;

abstract public class Level0ItemRoom extends Level0Room {
    private List<Item> itemList;
    private List<Item> removeItem = new ArrayList<>();

    /**
     * Item Room constructor
     * @param roomCoordinates (DiscreteCoordinates): the coordinates of the room.
     */
    public Level0ItemRoom(DiscreteCoordinates roomCoordinates) {
        super(roomCoordinates);
        itemList = new ArrayList<>();
    }

    @Override
    public boolean isOn() { return(super.isOn() && itemList.size() == 0);}

    @Override
    public void update(float deltaTime) {
        ListUpdate();
        super.update(deltaTime);

    }


    /** Updates the list of current items and adds the deleted items to a list of removed items* **/
    private void ListUpdate(){
        for(Item c : itemList){
            if (c.isCollected() == true && removeItem.contains(c) == false ){
                removeItem.add(c);
            }
        }
        for(Item c : removeItem){
            itemList.remove(c);
        }
    }

    @Override
    protected void createArea() {
        super.createArea();
        //register all items
        for(Item c : itemList){
            registerActor(c);
            }
        }

    /**
     * Adds an item to the list  of items.
      * @param item (Item): the item to add
     */
    protected void addItem(Item item){
        itemList.add(item);
    }
}
