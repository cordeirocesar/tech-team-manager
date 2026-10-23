import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {
        displayMenu();
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


}
