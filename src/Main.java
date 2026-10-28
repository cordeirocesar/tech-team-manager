import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeService employeeService = new EmployeeService();


    static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == Choice.REGISTER_EMPLOYEE.getCode()) {
                registerEmployee();
            }
            if (choice == Choice.LIST_EMPLOYEES.getCode()) {
                listEmployees();
                continue;
            }
            if (choice == Choice.DISPLAY_FINAL_SALARY.getCode()) {
                displayFinalSalaries();
            }
            if (choice == Choice.DISPLAY_EMPLOYEE_WITH_HIGHEST_SALARY.getCode()) {
                displayEmployeeWithHighestSalary();
            }
            if (choice == Choice.DISPLAY_EMPLOYEE_COUNT_BY_ROLE.getCode()) {
                displayEmployeeCountByRole();
            }
            if (choice == Choice.SEARCH_EMPLOYEE_BY_NAME.getCode()) {
                searchEmployeeByName();
            }
        } while(choice != Choice.EXIT.getCode());


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
        employeeService.addEmployee(employee);

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
        if (employees.isEmpty()) {
            System.out.println("No employees registered.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(
                    employee.getName() + " Final salary: " + employee.getFinalSalary()
            );
            System.out.println("--------------------");
        }

    }

    private static void displayEmployeeWithHighestSalary() {
        Employee employeeWithHighestSalary = null;
        for (Employee employee : employees) {
         if (employeeWithHighestSalary == null) {
             employeeWithHighestSalary = employee;
         } else {

             if(employee.getFinalSalary() > employeeWithHighestSalary.getFinalSalary()){
                 employeeWithHighestSalary = employee;
             }
         }

        }
        if (employeeWithHighestSalary != null) {
            System.out.println("Employee with highest final salary: " + employeeWithHighestSalary.getName());
        } else {
            System.out.println("No employee cadastred");
        }
        System.out.println("--------------------");

    }

    private static void displayEmployeeCountByRole() {

        if (employees.isEmpty()) {
            System.out.println("No employees registered.");
            return;
        }

        Map<Role, Integer> employeeCountByRole = new HashMap<>();

        for (Employee employee : employees) {
            Role role = employee.getRole();

            int currentCount = employeeCountByRole.getOrDefault(role, 0);

            employeeCountByRole.put(role, currentCount + 1);
        }

        for (Map.Entry<Role, Integer> entry : employeeCountByRole.entrySet()) {
            System.out.println(
                    entry.getKey().getDescription() + ": " + entry.getValue()
            );
        }
    }

        private static void searchEmployeeByName() {
            if (employees.isEmpty()) {
                System.out.println("No employees registered.");
                return;
            }

            System.out.println("Enter employee name: ");
            String name = scanner.nextLine().trim();

            boolean found = false;

            for (Employee employee : employees) {
                if (employee.getName().equalsIgnoreCase(name)) {
                    System.out.println("Employee found successfully!");
                    System.out.println("Name: " + employee.getName());
                    System.out.println("Role: " + employee.getRole().getDescription());
                    System.out.println("Salary: " + employee.getSalary());
                    System.out.println("Final salary: " + employee.getFinalSalary());
                    System.out.println("--------------------");

                    found = true;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        }
}
