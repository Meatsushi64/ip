package jen;
import jen.tasks.Task;
import jen.Parser;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Save {
    // creates a txt file to save the current list to a file
    // for now lets save the file into docs ../../../docs
    protected final String FILEPATH;
    private Scanner scanner;
    private File file;
    private FileWriter fileWriter;

    public Save(String filePath) {
        this.FILEPATH = filePath;
    }

    public boolean checkSaves() throws JenException {
        try {
            this.file = new File(FILEPATH);

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


    public void readSave(Storage storage, Parser parser) throws JenException{
        // reads the existing save file
        try {
            this.scanner = new Scanner(file);
            while (this.scanner.hasNext()) {
                String line = this.scanner.nextLine();
                Task t = parser.readSaveLine(line);
                storage.store(t);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
    public void writeSave(Storage storage) throws JenException {
        // stores the current storage into the file
        try {
            this.fileWriter = new FileWriter(this.file);
            while (!storage.isEmpty()) {
                Task t = storage.deleteItem(1);
                this.fileWriter.write(t.toSaveFormat());
                this.fileWriter.write(System.lineSeparator());
            }
            this.fileWriter.close();
        } catch (IOException e) {
            throw new JenException("Save file not found");
        }

    }
    public static void main(String[] args) {

    }

}
