package onTrack;

import onTrack.models.Resource;
import onTrack.models.Task;
import java.util.ArrayList;
import java.util.List;

public class ResourceRecommendation {
    public List<Resource> recommendResources(Task task) {
        List<Resource> resources = new ArrayList<>();
        String description = task.getDescription();
        if (description != null) {
            String lowerCaseDescription = description.toLowerCase();
            if (lowerCaseDescription.contains("java")) {
                resources.add(new Resource("Java Programming Guide"));
            }
            if (lowerCaseDescription.contains("python")) {
                resources.add(new Resource("Python Programming Guide"));
            }
        }
        return resources;
    }
}
