public class AddCommand extends Command{
    private Task toAdd;
    public AddCommand(Task task) {
        this.toAdd = task;
    }
    @Override
    public void run(Storage storage,  UI ui) {
        storage.store(this.toAdd);
        ui.printMessage("I've added [" + toAdd + "] to the list!");

    }
}
