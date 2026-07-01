package ch.epfl.cs107.play.game.icrogue;

import ch.epfl.cs107.play.window.Keyboard;

public interface ICRogueKeybinds {

    /**
     * Grouping all KeyBinds to make it easier to modify.
     */

    int UP = Keyboard.UP;
    int DOWN = Keyboard.DOWN;
    int LEFT = Keyboard.LEFT;
    int RIGHT = Keyboard.RIGHT;
    int SPRINT = Keyboard.W;
    int USE_WEAPON = Keyboard.Q;
    int SWITCH_WEAPON = Keyboard.S;
    int RESET_GAME = Keyboard.O;
    int PAUSE_GAME = Keyboard.ESCAPE;
    int INTERACT = Keyboard.E;

}
