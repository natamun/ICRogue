package icrogue.game.icrogue.MenuScreens;

import icrogue.game.PauseMenu;
import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Text;
import icrogue.math.DiscreteCoordinates;
import icrogue.window.Canvas;

import java.awt.*;

public class ICRogueWonMenu extends PauseMenu {
    private Text wonText;
    @Override
    protected void drawMenu(Canvas c) {
        //defines the wonText and  renders them on the canvas
        wonText = new Text("YOU WON", new DiscreteCoordinates(3,7), (Area) getOwner(), true, 2, Color.yellow);
        wonText.draw(c);
    }
}
