import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();

    static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                registerEmployee();
            }
            if (choice == 2) {
                listEmployees();
            }
            if (choice == 3) {
                displayFinalSalaries();
            }
            if (choice == 4) {
                displayEmployeeWithHighestSalary();
            }
        } while(choice != 7);


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

        System.out.println("Choose an option: ");
    }



    private static void registerEmployee() {
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter employee role (DEVELOPER, PRODUCT_MANAGER, DEVOPS): ");
        String roleInput = scanner.nextLine()
                .trim()
                .toUpperCase()
                .replaceAll("\\s+", "_");
        Role role = Role.valueOf(roleInput);

        Employee employee = new Employee(name, salary, role);
        employees.add(employee);

        System.out.println("Employee registered successfully!");
    }

    private static void listEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees registered.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Role: " + employee.getRole().getDescription());
            System.out.println("--------------------");
        }
    }

    private static void displayFinalSalaries() {
        for (Employee employee : employees) {
            String name = employee.getName();
            double baseSalary = employee.getSalary();
            double finalSalary = baseSalary + employee.getRole().calculateBonus(baseSalary);
            System.out.println(name + " Final salary: " + finalSalary);
            System.out.println("--------------------");

        }

    }

    private static void displayEmployeeWithHighestSalary() {
        Employee employeeWithHighestSalary = null;
        for (Employee employee : employees) {
         if (employeeWithHighestSalary == null) {
             employeeWithHighestSalary = employee;
         } else {
             double baseSalaryEmployeeWithHighestSalary = employeeWithHighestSalary.getSalary();
             double BonusSalaryEmployeeWithHighestSalary = employeeWithHighestSalary.getRole().calculateBonus(baseSalaryEmployeeWithHighestSalary);
             double finalSalaryEmployeeWithHighestSalary = baseSalaryEmployeeWithHighestSalary + BonusSalaryEmployeeWithHighestSalary;

             if(employee.getSalary() + employee.getRole().calculateBonus(employee.getSalary()) > finalSalaryEmployeeWithHighestSalary){
                 employeeWithHighestSalary = employee;
             }
         }

        }
        if (employeeWithHighestSalary != null) {
            System.out.println("Employee with highest final salary: " + employeeWithHighestSalary.getName());
        }

    }
}
