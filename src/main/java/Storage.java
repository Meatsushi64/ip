import java.util.ArrayList;
public class Storage {
    protected ArrayList<Task> store;

    public Storage() {
        this.store = new ArrayList<Task>(100);
    }

    public void store(String item) {
        this.store.add(new Task(item));
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
}
