public class UnmarkCommand extends Command{
    private int index;
    public UnmarkCommand(int i) {

        this.index = i;
    }
    @Override
    public void run(Storage storage, UI ui) throws OutOfIndexException {
        if (!storage.isWithinSize(this.index)) {
            throw new OutOfIndexException("Input index outside of list size");
        }
        storage.markAsNotDone(index);
        ui.printMessage("I have unmarked the task! \n" + storage.taskToString(index) +
                "\n" + storage.sizeToString());

    }
}
