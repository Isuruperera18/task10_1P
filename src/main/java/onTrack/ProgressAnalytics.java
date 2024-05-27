package onTrack;

import onTrack.models.ProgressReport;
import onTrack.models.Student;

public class ProgressAnalytics {

    public ProgressReport generateReport(Student student) {
        return new ProgressReport(student.getCompletedTasks().size(), student.getTotalTasks().size());
    }
}