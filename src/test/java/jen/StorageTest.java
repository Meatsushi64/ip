package jen;
import jen.tasks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
    private Storage storage;
    @BeforeEach
    void setUp() {
        storage = new Storage();
    }
    @Test
    void testDeleteItem_SingleDeletion() {
        Task task = new ToDo("Sample Task");
        storage.store(task);
        assertEquals(1, storage.size, "Storage should have 1 task before deletion");

        Task removedTask = storage.deleteItem(1);
        assertEquals(task, removedTask, "Deleted task should be the one that was added");
        assertEquals(0, storage.size, "Storage should be empty after deletion");
        assertTrue(storage.isEmpty(), "Storage should be empty after deleting the last task");
    }

    @Test
    void testDeleteItem_MultipleDeletions() {
        Task task1 = new ToDo("Task 1");
        Task task2 = new ToDo("Task 2");
        Task task3 = new ToDo("Task 3");

        storage.store(task1);
        storage.store(task2);
        storage.store(task3);

        assertEquals(3, storage.size, "Storage should have 3 tasks before deletion");

        Task removedTask = storage.deleteItem(2);
        assertEquals(task2, removedTask, "Deleted task should be Task 2");
        assertEquals(2, storage.size, "Storage size should decrease by 1 after deletion");

        // Ensure the order is maintained after deletion
        assertEquals(task1.toString(), storage.taskToString(1), "First task should still be Task 1");
        assertEquals(task3.toString(), storage.taskToString(2), "Second task should now be Task 3");
    }
    @Test
    void testDeleteItem_DeletesCorrectTask() {
        Task task1 = new ToDo("First Task");
        Task task2 = new ToDo("Second Task");
        storage.store(task1);
        storage.store(task2);

        Task removedTask = storage.deleteItem(1);
        assertEquals(task1, removedTask, "Deleted task should be the first task");
        assertEquals(1, storage.size, "Storage size should be 1 after deletion");
        assertEquals(task2.toString(), storage.taskToString(1), "Remaining task should be the second task");
    }

    @Test
    void testDeleteItem_SizeReduction() {
        Task task1 = new ToDo("Task 1");
        Task task2 = new ToDo("Task 2");

        storage.store(task1);
        storage.store(task2);
        assertEquals(2, storage.size, "Storage should initially have 2 tasks");

        storage.deleteItem(2);
        assertEquals(1, storage.size, "Storage size should -1 after deletion");

        storage.deleteItem(1);
        assertEquals(0, storage.size, "Storage should be empty after deleting all tasks");
        assertTrue(storage.isEmpty(), "Storage should be empty");
    }

    @Test
    void testDeleteItem_ThrowsExceptionForInvalidIndex() {
        Task task = new ToDo("Task X");
        storage.store(task);

        assertThrows(IndexOutOfBoundsException.class, () -> storage.deleteItem(2),
                "Should throw exception when deleting a non-existent item");

        assertThrows(IndexOutOfBoundsException.class, () -> storage.deleteItem(0),
                "Should throw exception when deleting at index 0");

        assertThrows(IndexOutOfBoundsException.class, () -> storage.deleteItem(-1),
                "Should throw exception when deleting at a negative index");
    }

    @Test
    void testDeleteItem_EmptyStorage() {
        assertThrows(IndexOutOfBoundsException.class, () -> storage.deleteItem(1),
                "Should throw exception when trying to delete from empty storage");
    }
}
