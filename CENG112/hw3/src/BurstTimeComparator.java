import java.util.Comparator;

public class BurstTimeComparator implements Comparator<Task> {
    public int compare(Task task1, Task task2) {
        return task1.getBurstTime() - task2.getBurstTime();
    }
}
