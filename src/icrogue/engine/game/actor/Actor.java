package icrogue.engine.game.actor;

import icrogue.engine.game.Updatable;
import icrogue.engine.math.Positionable;
import icrogue.engine.window.Audio;


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
