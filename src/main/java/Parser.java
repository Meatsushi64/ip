import java.util.Objects;

public class Parser {
    // control centre based on what the user inputs
    // handles what the user inputs into the UI


    public Command read(String input) {
        String[] arrayInput = input.split(" ", 2);
        String comd = arrayInput[0];

        switch (comd) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "todo":
                String todo = input.substring(5);
                return new AddCommand(new ToDo(todo));
            case "deadline":
                String[] deadline = input.substring(9).split(" /by ");
                return new AddCommand(new Deadline(deadline[0], deadline[1]));
            case "event":
                String[] event = input.substring(6).split(" /");
                String desc = event[0];
                String from = event[1].substring(5);
                String to = event[2].substring(3);
                return new AddCommand(new Event(desc, from, to));
            case "mark":
                return new MarkCommand(arrayInput[1]);
            case "unmark":
                return new UnmarkCommand(arrayInput[1]);
            default:
                return new ByeCommand();
        }

    }
}
