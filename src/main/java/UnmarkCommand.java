public class UnmarkCommand extends Command{
    private int index;
    public UnmarkCommand(String i) {

        this.index = Integer.parseInt(i);
    }
    @Override
    public void run(Storage storage, UI ui) {
        storage.markAsNotDone(index);
        ui.printMessage("I have unmarked the task! \n" + storage.taskToString(index));

    }
}
