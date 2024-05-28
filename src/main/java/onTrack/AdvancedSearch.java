package onTrack;

import onTrack.models.Task;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedSearch {
    public List<Task> searchTasks(List<Task> tasks, String keywords) {
        if (keywords == null || keywords.isEmpty()) {
            return Collections.emptyList();
        }
        Set<String> keywordSet = Stream.of(keywords.split("\\s+"))
                                       .map(String::toLowerCase)
                                       .collect(Collectors.toSet());
        
        return tasks.stream()
                .filter(task -> task.getDescription() != null && 
                                keywordSet.stream().anyMatch(keyword -> task.getDescription().toLowerCase().contains(keyword)))
                .collect(Collectors.toList());
    }

    public List<Task> searchTasksExact(List<Task> tasks, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }
        return tasks.stream()
                .filter(task -> task.getDescription() != null && task.getDescription().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
    }
}
