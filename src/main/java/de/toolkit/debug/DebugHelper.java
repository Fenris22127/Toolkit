package de.toolkit.debug;

import de.fenris.logger.ColorLogger;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class which provides some methods to debug an application.
 * @author &copy; 2023 Elisa Johanna Woelk | elisa-johanna.woelk@outlook.de | @fenris_22127
 * @version 1.1
 * @since 17.0.1
 */
public class DebugHelper {
    /**
     * Creates a {@link ColorLogger} for this class.
     */
    private static final Logger LOGGER = ColorLogger.newLogger(DebugHelper.class.getName());
    /**
     * Provides an {@link URL} to a large image. <br>
     * Dimensions: 4000 x 6000 px <br>
     * Credit: {@see <a href="https://unsplash.com/de/fotos/z99iWocuDt0">Iceland by Jonny Auh</a>}
     */
    private static final URL LARGE_IMAGE = DebugHelper.class.getResource("/de/toolkit/debug/L_Iceland (by Jonny Auh).jpg");
    /**
     * Provides an {@link URL} to a small image. <br>
     * Dimensions: 400 x 600 px <br>
     * Credit: {@see <a href="https://unsplash.com/de/fotos/z99iWocuDt0">Iceland by Jonny Auh</a>}
     */
    private static final URL SMALL_IMAGE = DebugHelper.class.getResource("/de/toolkit/debug/L_Iceland (by Jonny Auh).jpg");
    /**
     * Provides a {@link Path} to the download directory of the user.
     */
    private final Path downloadPath = Paths.get(System.getProperty("user.home").concat("/Downloads"));
    /**
     * Provides a {@link Path} to the documents directory of the user.
     */
    private final Path documentsPath = Paths.get(System.getProperty("user.home").concat("/Documents"));

    /**
     * Returns the {@link Path} to the download directory of the user.
     * @return A {@link Path}: The path of the download directory of the user.
     */
    public Path getDownloadPath() {
        return downloadPath;
    }

    /**
     * Returns the {@link Path} to the documents directory of the user.
     * @return A {@link Path}: The path of the documents directory of the user.
     */
    public Path getDocumentsPath() {
        return documentsPath;
    }

    /**
     * Returns a small {@link BufferedImage} from the {@link URL} to the {@link #SMALL_IMAGE small image}.<br>
     * Dimensions: 400 x 600 px <br>
     * Credit: {@see <a href="https://unsplash.com/de/fotos/z99iWocuDt0">Iceland by Jonny Auh</a>}
     * @return A {@link BufferedImage}: A small placeholder image.
     */
    public BufferedImage getSmallImage() {
        return getImageFromUrl(SMALL_IMAGE);
    }

    /**
     * Returns a large {@link BufferedImage} from the {@link URL} to the {@link #LARGE_IMAGE large image}.<br>
     * Dimensions: 4000 x 6000 px <br>
     * Credit: {@see <a href="https://unsplash.com/de/fotos/z99iWocuDt0">Iceland by Jonny Auh</a>}
     * @return A {@link BufferedImage}: A large placeholder image.
     */
    public BufferedImage getLargeImage() {
        return getImageFromUrl(LARGE_IMAGE);
    }

    /**
     * Returns a {@link BufferedImage} from the provided {@link URL}.
     * @param url A {@link URL}: The URL to the image.
     * @return A {@link BufferedImage}: The image the provided URL points to.
     */
    private static BufferedImage getImageFromUrl(URL url) {
        try {
            return javax.imageio.ImageIO.read(Objects.requireNonNull(url));
        }
        catch (java.io.IOException e) {
            LOGGER.log(Level.SEVERE, "IOException: Could not read image from provided URL!");
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            LOGGER.log(Level.SEVERE, "NullPointerException: Could not read image from provided URL! URL is null!");
            e.printStackTrace();
        }
        return null;
    }
}
