package ch.epfl.cs107.play.game.icrogue.MenuScreens;

import ch.epfl.cs107.play.game.PauseMenu;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Text;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

import java.awt.*;

public class ICRogueGameOverMenu extends PauseMenu {
    private Text gameOverText;
    @Override
    protected void drawMenu(Canvas c) {
        //defines the GAME OVER text then renders it on the canvas
        gameOverText = new Text("GAME OVER", new DiscreteCoordinates(3,7), (Area) getOwner(), true, 2, Color.red);
        gameOverText.draw(c);
    }
}
