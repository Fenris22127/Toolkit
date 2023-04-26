package de.toolkit.files;

import de.customlogger.logger.ColorLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileUtils {
    private static final Logger LOGGER = ColorLogger.newLogger(FileUtils.class.getName());
    private static void moveAndRenameFile() {
        Path path = Paths.get("[...]");
        File f = path.toFile();
        if (f.exists()) {
            long count = 0;
            try (Stream<Path> files = Files.list(Paths.get("[...]\\[...]\\[...]"))) {
                count = files.count() + 1;
            }
            catch (IOException e) {
                LOGGER.log(Level.SEVERE, "{0}: Could not access directory!", e.getClass().getSimpleName());
            }
            boolean r = f.renameTo(new File("[...]\\[...]\\[...]_" + count + "[...]"));
            LOGGER.log(Level.INFO, "Moved: {0}", r);
        }

    }
}
