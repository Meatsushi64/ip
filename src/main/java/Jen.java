public class Jen {
    private UI ui;
    private Parser parser;
    private Storage storage;
    private boolean isRunning = true;

    public Jen() {
        ui = new UI();
        parser = new Parser();
        storage = new Storage();
    }

    public static void main(String[] args) {
        Jen chatbot = new Jen();
        chatbot.start();
    }

    public void start() {
        ui.greet();
        while (isRunning) {
            Command cmd = parser.read(ui.readUserInput());

            cmd.run(storage, ui);

            if (cmd instanceof ByeCommand) {
                isRunning = false;
            }
        }
        ui.bye();
    }


}
