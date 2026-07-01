package ch.epfl.cs107.play.game.icrogue.MenuScreens;

import ch.epfl.cs107.play.game.PauseMenu;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Text;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

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
