public class MarkCommand extends Command {

    private int index;
    public MarkCommand(String i) {

        this.index = Integer.parseInt(i);
    }
    @Override
    public void run(Storage storage, UI ui) {
        storage.markAsDone(index);
        ui.printMessage("I have marked task as done!\n" + storage.taskToString(index));
        ;
    }
}
