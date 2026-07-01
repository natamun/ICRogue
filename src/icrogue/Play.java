package icrogue;

import icrogue.game.Game;
import icrogue.game.areagame.io.ResourcePath;
import icrogue.game.icrogue.ICRogue;
import icrogue.io.DefaultFileSystem;
import icrogue.io.FileSystem;
import icrogue.io.ResourceFileSystem;
import icrogue.window.Window;
import icrogue.window.swing.SwingWindow;

/**
 * Main entry point.
 */
public class Play {

	/** One second in nanosecond */
    private static final float ONE_SEC = 1E9f;
	public static final int WINDOW_HEIGHT = 550;
	public static final int WINDOW_WIDTH = 550;

	/**
	 * Main entry point.
	 * @param args (Array of String): ignored
	 */

	public static void main(String[] args) {

		// Define cascading file system
		final FileSystem fileSystem = new ResourceFileSystem(DefaultFileSystem.INSTANCE);

		final Game game = new ICRogue();

		// Use Swing display
		final Window window = new SwingWindow(game.getTitle(), fileSystem, WINDOW_WIDTH, WINDOW_HEIGHT);
		window.registerFonts(ResourcePath.FONTS);

		try {

			if (game.begin(window, fileSystem)) {

				// Use system clock to keep track of time progression
                long currentTime = System.nanoTime();
				long lastTime;
				final float frameDuration = ONE_SEC / game.getFrameRate();

				// Run until the user try to close the window
				while (!window.isCloseRequested()) {

					// Compute time interval
                    lastTime = currentTime;
                    currentTime = System.nanoTime();
					float deltaTime = (currentTime - lastTime);

                    try {
                        int timeDiff = Math.max(0, (int) (frameDuration - deltaTime));
                        Thread.sleep((int) (timeDiff / 1E6), (int) (timeDiff % 1E6));
                    } catch (InterruptedException e) {
                        System.out.println("Thread sleep interrupted");
                    }

                    currentTime = System.nanoTime();
                    deltaTime = (currentTime - lastTime) / ONE_SEC;

                    // Let the game do its stuff
                    game.update(deltaTime);

                    // Render and update input
                    window.update();
				}
			}

			game.end();

		} finally {
			// Release resources
			window.dispose();
		}
	}

}
