package jen.commands;
public enum CommandType {
    /** Represents a To-Do command. */
    TODO,

    /** Represents a Deadline command. */
    DEADLINE,

    /** Represents an Event command. */
    EVENT,

    /** Represents a List command to display tasks. */
    LIST,

    /** Represents a Mark command to mark a task as done. */
    MARK,

    /** Represents an Unmark command to mark a task as not done. */
    UNMARK,

    /** Represents a Delete command to remove a task. */
    DELETE,

    /** Represents a Bye command to exit the chatbot. */
    BYE,

    /** Represents an unknown or unrecognized command. */
    UNKNOWN
}
