import java.util.Scanner;
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return taskId + " - " + taskName + " - " + status;
    }
}

public class TaskManager {
    static Task head = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add\n2. Search\n3. View\n4. Delete\n5. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter ID, Name, Status: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String status = sc.next();
                    Task newTask = new Task(id, name, status);
                    if (head == null) head = newTask;
                    else {
                        Task temp = head;
                        while (temp.next != null)
                            temp = temp.next;
                        temp.next = newTask;
                    }
                }
                case 2 -> {
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();
                    Task temp = head;
                    boolean found = false;
                    while (temp != null) {
                        if (temp.taskId == id) {
                            System.out.println(temp);
                            found = true;
                            break;
                        }
                        temp = temp.next;
                    }
                    if (!found) System.out.println("Task not found.");
                }
                case 3 -> {
                    Task temp = head;
                    while (temp != null) {
                        System.out.println(temp);
                        temp = temp.next;
                    }
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    if (head == null) return;
                    if (head.taskId == id) {
                        head = head.next;
                        System.out.println("Deleted.");
                        continue;
                    }
                    Task prev = head;
                    Task curr = head.next;
                    while (curr != null && curr.taskId != id) {
                        prev = curr;
                        curr = curr.next;
                    }
                    if (curr != null) {
                        prev.next = curr.next;
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Task not found.");
                    }
                }
                case 5 -> System.exit(0);
            }
        }
    }
}
