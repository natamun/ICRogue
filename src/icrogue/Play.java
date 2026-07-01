package icrogue;

import icrogue.engine.game.Game;
import icrogue.engine.game.areagame.io.ResourcePath;
import icrogue.engine.io.DefaultFileSystem;
import icrogue.engine.io.FileSystem;
import icrogue.engine.io.ResourceFileSystem;
import icrogue.engine.window.Window;
import icrogue.engine.window.swing.SwingWindow;

import java.util.Optional;

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
	 * @param args (Array of String): optional map mode (random, classic, debug); defaults to random
	 */

	public static void main(String[] args) {

		Optional<ICRogue.MapMode> mapMode = parseMapMode(args);
		if (mapMode.isEmpty()) {
			System.err.println("Unknown map mode: " + args[0]);
			System.err.println("Usage: ./icrogue [random|classic|debug]");
			return;
		}

		// Define cascading file system
		final FileSystem fileSystem = new ResourceFileSystem(DefaultFileSystem.INSTANCE);

		final Game game = new ICRogue(mapMode.get());

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

	private static Optional<ICRogue.MapMode> parseMapMode(String[] args) {
		if (args.length == 0) return Optional.of(ICRogue.MapMode.RANDOM);
		return switch (args[0].toLowerCase()) {
			case "random" -> Optional.of(ICRogue.MapMode.RANDOM);
			case "classic" -> Optional.of(ICRogue.MapMode.CLASSIC);
			case "debug" -> Optional.of(ICRogue.MapMode.DEBUG);
			default -> Optional.empty();
		};
	}

}
