package jen.commands;
import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;

public abstract class Command {
    public abstract void run(Storage store, UI ui) throws OutOfIndexException;
}
