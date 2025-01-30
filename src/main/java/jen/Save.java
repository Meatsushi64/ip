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
    private static final String FILEPATH = "saves/saveFile.txt";
    private Scanner scanner;
    private File file;
    private FileWriter fileWriter;

    public Save() {
    }

    public boolean checkSaves() throws JenException{
        // check if the save file exists.
        try {
            this.file = new File(FILEPATH);
            return file.createNewFile();

        } catch (IOException e) {
            System.err.println(e);
            throw new JenException(e.getMessage());
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
