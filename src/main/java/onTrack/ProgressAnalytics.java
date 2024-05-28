package onTrack;

import onTrack.models.ProgressReport;
import onTrack.models.Student;
import java.util.Collections;

public class ProgressAnalytics {
    public ProgressReport generateReport(Student student) {
        int completedTasks = (student.getCompletedTasks() != null) ? student.getCompletedTasks().size() : 0;
        int totalTasks = (student.getTotalTasks() != null) ? student.getTotalTasks().size() : 0;
        return new ProgressReport(completedTasks, totalTasks);
    }
}
