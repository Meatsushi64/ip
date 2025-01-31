package jen;
import java.util.Scanner;

/**
 * Handles user interaction for the chatbot.
 * This class manages input and output operations.
 */
public class UI {
    /** Scanner object for reading user input. */
    private Scanner scanner;

    /**
     * Constructs a {@code UI} instance.
     * Initializes the scanner for user input.
     */
    public UI(){
        scanner = new Scanner(System.in);
    }

    /**
     * Prints the chatbot's greeting message.
     */
    public void greet() { // prints greeting
        System.out.println(Msg.LINE);
        System.out.println(Msg.GREETING);
        System.out.println(Msg.LINE);
    }

    /**
     * Prints a line separator.
     */
    public void line() { // prints a line
        System.out.println(Msg.LINE);
    }

    /**
     * Reads user input from the console.
     *
     * @return The user input as a string.
     */
    public String readUserInput() { // reads user input and returns the string
        String s = scanner.nextLine();
        return s;
    }

    /**
     * Prints a formatted message between two lines.
     *
     * @param msg The message to be printed.
     */
    public void printMessage(String msg) {
        this.line();
        System.out.println(msg);
        this.line();
    }

    /**
     * Prints an error message based on an exception.
     *
     * @param e The exception containing the error message.
     */
    public void printError(Exception e) {
        System.out.println("Error: "+ e.getMessage());
    }

    /**
     * Prints the chatbot's goodbye message.
     */
    public void bye() {
        System.out.println(Msg.GOODBYE);
    }
}
