package jen.commands;

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
    public void run(Storage store, UI ui) {
        store.addNoteToTask(this.index, this.note);
        ui.printMessage("Note added to Task " + this.index + " : " + note + "\n");
        ui.printMessage(store.taskToString(this.index));
    }
}
