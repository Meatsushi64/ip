package jen;
import jen.commands.Command;
import jen.commands.ByeCommand;
public class Jen {
    private UI ui;
    private Parser parser;
    private Storage storage;
    private boolean isRunning = true;
    private Save save;

    public Jen() {
        this.ui = new UI();
        this.parser = new Parser();
        this.storage = new Storage();
        this.save = new Save("saves/saveFile.txt");
    }

    public static void main(String[] args) {
        Jen chatbot = new Jen();
        chatbot.start();
    }

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
