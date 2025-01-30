package jen.commands;

import jen.Storage;
import jen.UI;

public class ListCommand extends Command {
    @Override
    public void run(Storage storage, UI ui) {
        ui.line();
        storage.printStorage();
        ui.line();
    }
}
