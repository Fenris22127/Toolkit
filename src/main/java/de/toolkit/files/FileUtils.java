package de.toolkit.files;

import de.fenris.logger.ColorLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class which provides some methods for file handling.
 * @author &copy; 2023 Elisa Johanna Woelk | elisa-johanna.woelk@outlook.de | @fenris_22127
 * @version 1.2
 * @since 17.0.1
 */
public class FileUtils {
    /**
     * Creates a {@link ColorLogger} for this class.
     */
    private static final Logger LOGGER = ColorLogger.newLogger(FileUtils.class.getName());

    /**
     * Moves a file from one directory to another and changes the name of the file if the file already exists in the
     * target directory.
     * @param moveFrom A {@link Path}: The path of the file to move.
     * @param moveTo A {@link Path}: The path of the target directory.
     */
    private static void moveAndRenameFile(Path moveFrom, Path moveTo) {
        if (Files.exists(moveFrom)) {
            if (Files.exists(moveTo)) {
                Path newNamePath = getFileName(moveFrom);
                try {
                    Files.move(moveFrom, newNamePath);
                }
                catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "IOException: Could not move file!");
                    e.printStackTrace();
                }
            }
        }
        else {
            LOGGER.log(Level.WARNING, "File does not exist!");
        }

    }

    /**
     * Gets the name of a file and changes its name if it already exists in the target directory.
     * @param path A {@link Path}: The path of the file to rename.
     * @return A {@link Path}: The path of the renamed file.
     */
    protected static Path getFileName(Path path) {
        int fileNumber = 1;
        Path filePath = path;
        String name = String.valueOf(path.getFileName()).substring(0, String.valueOf(path.getFileName()).lastIndexOf("."));
        String newName = name;
        String oldName;
        while (Files.exists(filePath)) {
            oldName = newName;
            newName = String.format("%s (%d)", name, fileNumber);
            filePath = Paths.get(filePath.toString().replace(oldName, newName));
            fileNumber++;
        }
        return filePath;
    }
}
