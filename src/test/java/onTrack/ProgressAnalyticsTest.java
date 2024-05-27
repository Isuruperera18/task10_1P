package onTrack;

import static org.junit.Assert.assertEquals;

import onTrack.models.ProgressReport;
import onTrack.models.Student;
import onTrack.models.Task;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ProgressAnalyticsTest {

    @Test
    public void testGenerateReportWithCompletedTasks() {
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");
        Student student = new Student("1", "John Doe", Arrays.asList(task1, task2), Arrays.asList(task1, task2));
        ProgressAnalytics analytics = new ProgressAnalytics();
        ProgressReport report = analytics.generateReport(student);

        assertEquals(2, report.getCompletedTasks());
        assertEquals(2, report.getTotalTasks());
    }

    @Test
    public void testGenerateReportWithNoCompletedTasks() {
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");
        Student student = new Student("1", "John Doe", Collections.emptyList(), Arrays.asList(task1, task2));
        ProgressAnalytics analytics = new ProgressAnalytics();
        ProgressReport report = analytics.generateReport(student);

        assertEquals(0, report.getCompletedTasks());
        assertEquals(2, report.getTotalTasks());
    }

    @Test
    public void testGenerateReportWithSomeCompletedTasks() {
        Task task1 = new Task("1", "Task 1");
        Task task2 = new Task("2", "Task 2");
        Student student = new Student("1", "John Doe", Arrays.asList(task1), Arrays.asList(task1, task2));
        ProgressAnalytics analytics = new ProgressAnalytics();
        ProgressReport report = analytics.generateReport(student);

        assertEquals(1, report.getCompletedTasks());
        assertEquals(2, report.getTotalTasks());
    }

    @Test
    public void testGenerateReportWithNoTasks() {
        Student student = new Student("1", "John Doe", Collections.emptyList(), Collections.emptyList());
        ProgressAnalytics analytics = new ProgressAnalytics();
        ProgressReport report = analytics.generateReport(student);

        assertEquals(0, report.getCompletedTasks());
        assertEquals(0, report.getTotalTasks());
    }
}
