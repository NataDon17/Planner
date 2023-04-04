package Planner;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private final Map<Integer, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public void addTaskToMap(Task task) {
        tasks.put(task.getId(), task);
        System.out.println("Создана задача: \n" + task);
    }

    public Collection<Task> getAllByDate(LocalDate date) {
        List<Task> taskList = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.appearsIn(date))
                taskList.add(task);
        }
        return taskList;
    }

    public Task removeTasks(int i) throws TaskNotFoundException {
        if (!tasks.containsKey(i)) {
            throw new TaskNotFoundException();
        }
        tasks.remove(i);
        System.out.println("Задача под номером " + i + " удалена.");
        return null;
    }
}
