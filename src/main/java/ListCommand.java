public class ListCommand extends Command {
    @Override
    public void run(Storage storage, UI ui) {
        ui.line();
        storage.printStorage();
        ui.line();
    }
}
