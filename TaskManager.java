import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Task {
    private String name;
    private String description;
    private Priority priority;
    private String dueDate;

    public Task(String name, String description, Priority priority, String dueDate) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDateFormatted = LocalDate.parse(this.dueDate, formatter);
        return currentDate.isAfter(dueDateFormatted);
    }

    @Override
    public String toString() {
        return "Task: " + name + "\nDescription: " + description + "\nPriority: " + priority +
                "\nDue Date: " + dueDate + "\n";
    }
}

enum Priority {
    HIGH, MEDIUM, LOW
}

class TaskManager {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        Task task1 = new Task("Complete Java Project", "Finish coding and testing", Priority.HIGH, "2023-12-05");
        Task task2 = new Task("Buy Groceries", "Milk, eggs, bread", Priority.MEDIUM, "2023-10-01");
        Task task3 = new Task("Read Book", "Read 'The Great Gatsby'", Priority.LOW, "2023-12-10");

        scheduler.addTask(task1);
        scheduler.addTask(task2);
        scheduler.addTask(task3);

        List<Task> allTasks = scheduler.getTasks();
        LocalDate currentDate = LocalDate.now();
        System.out.println("Today's Date: " + currentDate);
        System.out.println("Tasks:");
        for (Task task : allTasks) {
            System.out.println(task);
            if (task.isOverdue()) {
                System.out.println("This task is overdue!");
            }
            System.out.println();
        }
    }
}

class TaskScheduler {
    private List<Task> tasks;

    public TaskScheduler() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
