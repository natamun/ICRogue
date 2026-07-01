package ch.epfl.cs107.play.game.icrogue.MenuScreens;

import ch.epfl.cs107.play.game.PauseMenu;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Text;
import ch.epfl.cs107.play.game.icrogue.actor.ICRogueGraphics;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

import java.awt.*;

public class ICRoguePauseMenu extends PauseMenu {
    private Text pauseText, pauseText2;
    @Override
    protected void drawMenu(Canvas c) {
        //defines the pauseText and a pauseText2  and  renders them on the canvas
        pauseText = new Text("Menu paused", new DiscreteCoordinates(3,7), (Area) getOwner(), true, 2, Color.white);
        pauseText2 = new Text("press escape to resume", new DiscreteCoordinates(3,4), (Area) getOwner(), true, 1, Color.white);
        pauseText.draw(c);
        pauseText2.draw(c);
    }

}
