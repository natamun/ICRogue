package icrogue.game.actor;

import icrogue.window.Audio;


public interface Acoustics {

    /**
     * Play itself on specified Audio context.
     * @param audio (Audio) target, not null
     */
    void bip(Audio audio);
}
