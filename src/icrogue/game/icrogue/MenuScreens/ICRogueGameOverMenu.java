package icrogue.game.icrogue.MenuScreens;

import icrogue.game.PauseMenu;
import icrogue.game.areagame.Area;
import icrogue.game.areagame.actor.Text;
import icrogue.math.DiscreteCoordinates;
import icrogue.window.Canvas;

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
