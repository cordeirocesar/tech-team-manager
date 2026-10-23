import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();

    static void main(String[] args) {
        displayMenu();
        registerEmployee();
    }

    private static void displayMenu() {
        System.out.println("""
                1 - Register Employee
                
                2 - List Employees
                
                3 - Display Final Salaries
                
                4 - Display Employee with Highest Salary
                
                5 - Display Employee Count by Role
                
                6 - Search Employee by Name
                
                7 - Exit
                """);
    }

    private static void registerEmployee() {
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter employee role: ");
        Role role = Role.valueOf(scanner.nextLine().trim().toUpperCase());

        Employee employee = new Employee(name, salary, role);
        employees.add(employee);

        System.out.println("Employee registered successfully!");

    }
}
