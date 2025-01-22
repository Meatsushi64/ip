public class ListCommand extends Command {
    @Override
    public void run(Storage store, UI ui) {
        ui.line();
        store.printStorage();
        ui.line();
    }
}
