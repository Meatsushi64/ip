package jen.commands;
import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;

public class DeleteCommand extends Command {
    private int index;
    public DeleteCommand(int i) {
        this.index = i;
    }
    @Override
    public void run(Storage storage, UI ui) throws OutOfIndexException {
        if (!storage.isWithinSize(this.index)) {
            throw new OutOfIndexException("Input index outside of list size");
        }
        ui.printMessage("I have removed this task:\n" + storage.deleteItem(this.index) +
                "\n" + storage.sizeToString());
    }
}
