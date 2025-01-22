public class Jen {
    private UI ui;
    private Parser parser;
    private Storage storage;
    private boolean isRunning = true;

    public Jen() {
        this.ui = new UI();
        this.parser = new Parser();
        this.storage = new Storage();
    }

    public static void main(String[] args) {
        Jen chatbot = new Jen();
        chatbot.start();
    }

    public void start() {
        this.ui.greet();
        while (isRunning) {
            Command cmd = parser.read(ui.readUserInput());

            cmd.run(storage, ui);

            if (cmd instanceof ByeCommand) {
                this.isRunning = false;
            }
        }
        this.ui.bye();
    }


}
