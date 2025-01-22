public class Jen {
    private UI ui;
    private Parser parser;

    public Jen() {
        ui = new UI();
        parser = new Parser();
    }

    public static void main(String[] args) {
        Jen chatbot = new Jen();
        chatbot.start();
    }

    public void start() {
        ui.greet();
        while (parser.status) {
            parser.read(ui.readUserInput());
        }
        ui.bye();
    }


}
