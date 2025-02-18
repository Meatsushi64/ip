package jen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import jen.tasks.Task;


/**
 * Handles saving and loading tasks to and from a file.
 * This class manages file operations for persistent storage of tasks.
 */
public class Save {
    // creates a txt file to save the current list to a file
    // for now lets save the file into docs ../../../docs
    @SuppressWarnings({"checkstyle:AbbreviationAsWordInName", "CheckStyle"})
    private final String FILE_PATH;
    private Scanner scanner;
    private File file;
    private FileWriter fileWriter;

    /**
     * Constructs a new {@code Save} instance with the specified file path.
     *
     * @param filePath The path to the file used for saving tasks.
     */
    public Save(String filePath) {
        this.FILE_PATH = filePath;
    }
    /**
     * Checks if a save file exists. If not, creates a new save file.
     *
     * @return {@code true} if a new file was created, {@code false} if the file already existed.
     * @throws JenException If an error occurs while checking or creating the file.
     */
    public boolean hasSaveFile() throws JenException {
        try {
            this.file = new File(FILE_PATH);

            // Ensure parent directories exist
            File parentDir = this.file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (!parentDir.mkdirs()) {
                    throw new IOException("Failed to create directory: " + parentDir.getAbsolutePath());
                }
            }

            // Create the file if it does not exist
            boolean isNewFileCreated = this.file.createNewFile();

            // Check if file is writable
            if (!this.file.canWrite()) {
                throw new IOException("File exists but is not writable: " + this.file.getAbsolutePath());
            }

            return isNewFileCreated;
        } catch (IOException e) {
            throw new JenException("Error checking or creating save file: " + e.getMessage());
        }
    }

    /**
     * Reads the save file and loads tasks into storage.
     *
     * @param storage The storage where tasks will be loaded.
     * @param parser  The parser used to interpret saved task data.
     * @throws JenException If an error occurs while reading the save file.
     */
    public void readSave(Storage storage, Parser parser) throws JenException {
        // reads the existing save file
        try {
            this.scanner = new Scanner(file);
            while (this.scanner.hasNext()) {
                String line = this.scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                Task t = parser.readSaveLine(line);
                storage.store(t);
            }
        } catch (FileNotFoundException e) {
            throw new JenException(e.getMessage());
        }
    }
    /**
     * Writes the current tasks in storage to the save file.
     *
     * @param storage The storage containing tasks to be saved.
     * @throws JenException If an error occurs while writing to the file.
     */
    public void writeSave(Storage storage) throws JenException {
        // stores the current storage into the file
        try {
            this.fileWriter = new FileWriter(this.file);
            for (int i = 0; i < storage.size; i++) {
                Task t = storage.getTask(i);
                this.fileWriter.write(t.toSaveFormat());
                this.fileWriter.write(System.lineSeparator());
            }
            this.fileWriter.close();
        } catch (IOException e) {
            throw new JenException("Save file not found");
        }

    }

}
