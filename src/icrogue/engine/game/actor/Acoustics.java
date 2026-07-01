package icrogue.engine.game.actor;

import icrogue.engine.window.Audio;


public interface Acoustics {

    /**
     * Play itself on specified Audio context.
     * @param audio (Audio) target, not null
     */
    void bip(Audio audio);
}
