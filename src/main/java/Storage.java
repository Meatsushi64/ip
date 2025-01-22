import java.util.ArrayList;
public class Storage {
    ArrayList<String> store;

    public Storage() {
        store = new ArrayList<String>(100);
    }

    public void store(String item) {
        store.add(item);
    }

    public void printStorage() {
        for (int i = 0; i < store.size(); i++) {
            System.out.println((i + 1) + ". " + store.get(i));
        }
    }
}
