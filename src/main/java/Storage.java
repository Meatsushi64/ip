import java.util.ArrayList;
public class Storage {
    protected ArrayList<Task> store;

    protected int size;

    public Storage() {
        this.store = new ArrayList<Task>(100);
        this.size = 0;
    }

    public void store(Task item) {
        this.store.add(item);
        this.size++;
    }

    public void printStorage() {
        for (int i = 0; i < this.store.size(); i++) {
            System.out.println((i + 1) + ". " + this.store.get(i));
        }
    }

    public void markAsDone(int i) {
        this.store.get(i - 1).markAsDone();
    }

    public void markAsNotDone(int i) {
        this.store.get(i - 1).markAsNotDone();
    }

    public String taskToString(int i) {
        return this.store.get(i - 1).toString();
    }
}
