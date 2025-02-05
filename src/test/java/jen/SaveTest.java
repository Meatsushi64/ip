package jen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class SaveTest {
    private Save save;
    @SuppressWarnings({"checkstyle:DeclarationOrder", "checkstyle:ModifierOrder"})
    private final static String TEST_FILE_PATH = "saves/testSaveFile.txt";

    @BeforeEach
    void setUp() {
        save = new Save(TEST_FILE_PATH);
        // Ensure test environment is clean before each test
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testCheckSavesFileDoesNotExist() throws JenException {
        File testFile = new File(TEST_FILE_PATH);
        assertFalse(testFile.exists(), "Test file should not exist before checkSaves call");

        boolean result = save.hasSaveFile();

        assertTrue(testFile.exists(), "checkSaves should create the file if it does not exist");
        assertTrue(result, "checkSaves should return true when a new file is created");
    }

    @Test
    void testCheckSavesFileAlreadyExists() throws JenException, IOException {
        File testFile = new File(TEST_FILE_PATH);
        boolean created = testFile.createNewFile();
        assertTrue(created, "Test setup should create the file before checkSaves call");

        boolean result = save.hasSaveFile();

        assertFalse(result, "checkSaves should return false if the file already exists");
    }

}
