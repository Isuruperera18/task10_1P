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
}
