package jen.commands;

import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;

/**
 * Represents a command to add a note.
 */
public class NoteCommand extends Command {
    private String note;
    private int index;
    /**
     * Constructs a {@code NoteCommand} with the specified note.
     *
     * @param i The index of the task to be marked as done.
     */
    public NoteCommand(int i, String note) {
        this.index = i;
        this.note = note;
    }

    @Override
    public void run(Storage storage, UI ui) throws OutOfIndexException {
        if (!storage.isWithinSize(this.index)) {
            throw new OutOfIndexException("Input index outside of list size");
        }
        storage.addNoteToTask(this.index, this.note);
        ui.printMessage("Note added to Task " + this.index + " : " + note + "\n");
        ui.printMessage(storage.taskToString(this.index));
    }
}
