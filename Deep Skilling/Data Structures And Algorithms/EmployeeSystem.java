import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String pos, double sal) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = sal;
    }

    public String toString() {
        return employeeId + " - " + name + " - " + position + " - ₹" + salary;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100];
        int count = 0;

        while (true) {
            System.out.println("\n1. Add\n2. Search\n3. View All\n4. Delete\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID, Name, Position, Salary: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String pos = sc.next();
                    double sal = sc.nextDouble();
                    employees[count++] = new Employee(id, name, pos, sal);
                }
                case 2 -> {
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (employees[i].employeeId == id) {
                            System.out.println(employees[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Employee not found");
                }
                case 3 -> {
                    for (int i = 0; i < count; i++)
                        System.out.println(employees[i]);
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (employees[i].employeeId == id) {
                            for (int j = i; j < count - 1; j++)
                                employees[j] = employees[j + 1];
                            count--;
                            System.out.println("Deleted.");
                            break;
                        }
                    }
                }
                case 5 -> System.exit(0);
            }
        }
    }
}
