package ch.epfl.cs107.play.game.icrogue.actor;

import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.io.ResourcePath;
import ch.epfl.cs107.play.math.TextAlign;
import ch.epfl.cs107.play.math.Vector;
import java.awt.*;

public interface ICRogueGraphics {
    /**
     * Globals graphics that some entity can use.
     */
    ImageGraphics gearGraph = new ImageGraphics(ResourcePath.getSprite("zelda/gearDisplay"),1.5f, 1.5f, null,new Vector(10,8.6f));
    Sprite currentGearGraph = new Sprite(null,.75f,.75f, null,null,new Vector(10.4f,8.95f));
    Sprite dialogGraph = new Sprite("zelda/dialog",12,2,null,null, new Vector(-1,-1));
    TextGraphics dialogText = new TextGraphics("you're not suppose to see this, that mean there is a bug",
            0.55f,Color.BLACK,null, 0,false,false,new Vector(5,0.2f),
            TextAlign.Horizontal.CENTER, TextAlign.Vertical.MIDDLE,1f,0.0f);

    Sprite[] hearthDisplay = Sprite.extractSprites("zelda/heartDisplay", 3, 1f,1f,null, new Vector(1,10),16,16);
    Sprite[] hearthDisplaySmall = Sprite.extractSprites("zelda/heartDisplay", 3, .5f,.5f,null, new Vector(1,10),16,16);

}