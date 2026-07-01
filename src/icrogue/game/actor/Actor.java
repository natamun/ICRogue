package icrogue.game.actor;

import icrogue.game.Updatable;
import icrogue.math.Positionable;
import icrogue.window.Audio;


/**
 * Top game object, which is directly managed by the game.
 * Smaller components and helpers are usually owned by actors themselves.
 */
public interface Actor extends Updatable, Graphics, Acoustics, Positionable{
    
    @Override
    default void update(float deltaTime) {
        // By default, actors have nothing to update
    }

    @Override
    default void bip(Audio audio){
        // by default no sound is beeped for actor
    }
}
