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
            case "add":
                return new AddCommand(arrayInput[1]);
            case "mark":
                return new MarkCommand(arrayInput[1]);
            case "unmark":
                return new UnmarkCommand(arrayInput[1]);
            default:
                return new ByeCommand();
        }

    }
}
