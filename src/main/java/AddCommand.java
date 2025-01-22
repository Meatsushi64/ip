public class AddCommand extends Command{
    private String toAdd;
    public AddCommand(String item) {
        toAdd = item;
    }
    @Override
    public void run(Storage store,  UI ui) {
        store.store(toAdd);
        ui.printMessage("I've added [" + toAdd + "] to the list!");

    }
}
