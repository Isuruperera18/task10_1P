package onTrack;

import static org.junit.Assert.assertEquals;

import onTrack.models.Resource;
import onTrack.models.Task;
import org.junit.Test;

import java.util.List;

public class ResourceRecommendationTest {

    @Test
    public void testRecommendResourcesForJavaTask() {
        ResourceRecommendation recommendation = new ResourceRecommendation();
        Task task = new Task("1", "This is a task about Java", "This is a task about Java");

        List<Resource> resources = recommendation.recommendResources(task);

        assertEquals(1, resources.size());
        assertEquals("Java Programming Guide", resources.get(0).getName());
    }

    @Test
    public void testRecommendResourcesForPythonTask() {
        ResourceRecommendation recommendation = new ResourceRecommendation();
        Task task = new Task("2", "This is a task about Python", "This is a task about Python");

        List<Resource> resources = recommendation.recommendResources(task);

        assertEquals(1, resources.size());
        assertEquals("Python Programming Guide", resources.get(0).getName());
    }

    @Test
    public void testRecommendResourcesForBothJavaAndPythonTask() {
        ResourceRecommendation recommendation = new ResourceRecommendation();
        Task task = new Task("3", "This is a task about Java and Python", "This is a task about Java and Python");

        List<Resource> resources = recommendation.recommendResources(task);

        assertEquals(2, resources.size());
        assertEquals("Java Programming Guide", resources.get(0).getName());
        assertEquals("Python Programming Guide", resources.get(1).getName());
    }

    @Test
    public void testNoResourcesForUnrelatedTask() {
        ResourceRecommendation recommendation = new ResourceRecommendation();
        Task task = new Task("4", "This is a task about C++", "This is a task about C++");

        List<Resource> resources = recommendation.recommendResources(task);

        assertEquals(0, resources.size());
    }
}
