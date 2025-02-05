package jen;

/**
 * Represents a custom exception specific to the Jen chatbot.
 * This exception is thrown when the chatbot encounters an error during execution.
 */
public class JenException extends Exception {

    /**
     * Constructs a new {@code JenException} with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public JenException(String message) {
        super(message);
    }
}
