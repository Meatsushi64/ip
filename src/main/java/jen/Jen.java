package jen;
import jen.commands.ByeCommand;
import jen.commands.Command;

/**
 * The main class for the Jen chatbot application.
 * It initializes the necessary components and handles the chatbot's execution flow.
 */
public class Jen {
    /** The UI component that handles user interaction. */
    private UI ui;

    /** The parser that processes user input and commands. */
    private Parser parser;

    /** The storage that manages task data. */
    private Storage storage;

    /** Indicates whether the chatbot is currently running. */
    private boolean isRunning = true;

    /** The save manager that handles saving and loading tasks. */
    private Save save;

    /**
     * Constructs a new instance of Jen.
     * Initializes the UI, Parser, Storage, and Save components.
     */
    public Jen() {
        this.ui = new UI();
        this.parser = new Parser();
        this.storage = new Storage();
        this.save = new Save("saves/saveFile.txt");
    }

    /**
     * The entry point for the Jen chatbot application.
     * It creates a new Jen instance and starts the chatbot.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Jen chatbot = new Jen();
        chatbot.start();
    }

    /**
     * Starts the chatbot and handles user interactions.
     * It greets the user, loads save data if available, and processes user commands.
     */
    public void start() {
        this.ui.greet();
        try {
            if (this.save.checkSaves()) {
                this.ui.printMessage("No save file detected, new save file created!");
            } else {
                this.ui.printMessage("Save file detected, loading current list");
                // read the save file
                this.save.readSave(this.storage, this.parser);
            }
        } catch (JenException e) {
            this.ui.printError(e);
        }
        while (isRunning) {
            try {
                Command cmd = parser.read(ui.readUserInput());


                cmd.run(storage, ui);

                if (cmd instanceof ByeCommand) {
                    this.isRunning = false;
                }
            } catch (JenException | OutOfIndexException e) {
                this.ui.printError(e);
            }
        }
        try {
            this.save.writeSave(this.storage);
        } catch (JenException e) {
            this.ui.printError(e);
        }
        this.ui.bye();
    }


}
