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

    @Test
    public void testSearchTasksWithNoMatchingKeyword() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is another task", "This is another task");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, "Ruby");
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchTasksWithMultipleKeywords() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is a task about Python", "This is a task about Python");
        Task task3 = new Task("3", "This is another task", "This is another task");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2, task3);

        List<Task> resultJava = search.searchTasks(tasks, "Java");
        List<Task> resultPython = search.searchTasks(tasks, "Python");

        assertEquals(1, resultJava.size());
        assertEquals("This is a task about Java", resultJava.get(0).getDescription());
         
        assertEquals(1, resultPython.size());
        assertEquals("This is a task about Python", resultPython.get(0).getDescription());
    }

    @Test
    public void testSearchTasksWithEmptyKeyword() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is another task", "This is another task");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, "");
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchTasksWithNullKeyword() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is another task", "This is another task");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, null);
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchTasksWithPartialMatchKeyword() {
        Task task1 = new Task("1", "This is a task about JavaScript", "This is a task about JavaScript");
        Task task2 = new Task("2", "This is another task", "This is another task");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, "Java");
        assertEquals(1, result.size());
        assertEquals("This is a task about JavaScript", result.get(0).getDescription());
    }

    @Test
    public void testSearchTasksWithMultipleMatchingKeywords() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is a task about Python", "This is a task about Python");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, "Java Python");
        assertEquals(2, result.size());
        assertEquals("This is a task about Java", result.get(0).getDescription());
        assertEquals("This is a task about Python", result.get(1).getDescription());
    }

    @Test
    public void testSearchTasksWithExactMatchKeyword() {
        Task task1 = new Task("1", "This is a task about Java", "This is a task about Java");
        Task task2 = new Task("2", "This is a task about Python", "This is a task about Python");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> result = search.searchTasks(tasks, "exactly Java");
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchTasksWithSpecialCharactersInKeyword() {
        Task task1 = new Task("1", "This is a task about Java#", "This is a task about Java#");
        Task task2 = new Task("2", "This is a task about Python$", "This is a task about Python$");
        AdvancedSearch search = new AdvancedSearch();
        List<Task> tasks = Arrays.asList(task1, task2);

        List<Task> resultJava = search.searchTasks(tasks, "Java#");
        List<Task> resultPython = search.searchTasks(tasks, "Python$");

        assertEquals(1, resultJava.size());
        assertEquals("This is a task about Java#", resultJava.get(0).getDescription());

        assertEquals(1, resultPython.size());
        assertEquals("This is a task about Python$", resultPython.get(0).getDescription());
    }
}
