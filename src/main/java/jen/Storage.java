package jen;

import jen.tasks.*;
import java.util.ArrayList;

/**
 * This class represents a storage system for tasks.
 */
public class Storage {
    /**
     * ArrayList of Tasks to store the tasks.
     */
    protected ArrayList<Task> tasks;
    /**
     * Number of tasks in the list.
     */
    protected int size;

    /**
     * Constructor for the storage class
     */
    public Storage() {
        this.tasks = new ArrayList<Task>(100);
        this.size = 0;
    }

    /**
     * Returns a boolean representing whether the list is empty.
     * True means that the list is empty. False otherwise.
     *
     * @return boolean representing whether the list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the current item to the ArrayList of Tasks.
     * It increments the size, which represents the number of items in the list
     *
     * @param item Task to be added to the list.
     */
    public void store(Task item) {
        this.tasks.add(item);
        this.size++;
    }

    /**
     * Prints the string representation of all the Tasks in the current list.
     */
    public void printStorage() {
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println((i + 1) + ". " + this.tasks.get(i));
        }
    }

    /**
     * Deletes the task at index (i - 1) of the list. ArrayList starts at index 0, so when user
     * deletes item 1 in the list of tasks, it would delete the first item at index 0 in the ArrayList
     *
     * @param i Index of the Task to be deleted.
     * @return Task that is removed from the storage.
     */
    public Task deleteItem(int i) {
        this.size--;
        return this.tasks.remove(i - 1);
    }

    /**
     * Checks whether the index i is within the number
     * @param i Index to be checked
     * @return boolean representing whether the index is within the size of the list.
     */
    public boolean isWithinSize(int i) {
        // return true when index is less than or equal to number of items in list
        return i <= this.size && i > 0;
    }

    /**
     * Marks the task at index (i - 1) as complete.
     * @param i
     */
    public void markAsDone(int i) {
        this.tasks.get(i - 1).markAsDone();
    }

    /**
     * Returns a String message announcing the number of Tasks left in the storage.
     * @return String message announcing the number of Tasks left in the storage.
     */
    public String sizeToString() {
        return "You currently have " + this.size + " tasks in the list";
    }

    /**
     * Marks the Task at index (i - 1) as completed.
     * @param i Index of the Task to be marked as completed.
     */
    public void markAsNotDone(int i) {
        this.tasks.get(i - 1).markAsNotDone();
    }

    /**
     * Returns String representation of the current task at index (i - 1)
     * @param i Index of the Task to be converted to a String.
     * @return String representation of the Task at index (i - 1)
     */
    public String taskToString(int i) {
        return this.tasks.get(i - 1).toString();
    }
}
