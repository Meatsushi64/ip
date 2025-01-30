package jen.commands;

import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;

public class MarkCommand extends Command {

    private int index;
    public MarkCommand(int i) {

        this.index = i;
    }
    @Override
    public void run(Storage storage, UI ui) throws OutOfIndexException {
        if (!storage.isWithinSize(this.index)) {
            throw new OutOfIndexException("Input index outside of list size");
        }
        storage.markAsDone(index);
        ui.printMessage("I have marked task as done!\n" + storage.taskToString(index) +
                "\n" + storage.sizeToString());
    }
}
