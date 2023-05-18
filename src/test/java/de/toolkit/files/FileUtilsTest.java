package de.toolkit.files;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static de.toolkit.files.FileUtils.getFileName;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {
    @Test
    void testGetFileName() {
        Path resourceDirectory = Paths.get("src","test","resources");
        Path pp = resourceDirectory.resolve("testFile.txt");
        String expected = "src\\test\\resources\\testFile (4).txt";

        assertEquals(expected, getFileName(pp).toString(), "The new file name should be testFile (4).txt");
    }

}