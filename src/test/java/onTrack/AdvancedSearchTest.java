package onTrack;

import static org.junit.Assert.assertEquals;
import onTrack.models.Task;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class AdvancedSearchTest {
    @Test
    public void testSearchTasksWithKeyword() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is another task", "This is another task");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, "Java");
        assertEquals(1, result.size());
        assertEquals("This is a task about Java", result.get(0).getDescription());
    }
}