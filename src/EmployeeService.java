import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name.trim())) {
                return employee;
            }
        }
        return null;
    }

    public Map<Role, Integer> getEmployeeCountByRole() {
        Map<Role, Integer> employeeCountByRole = new HashMap<>();

        for (Employee employee : employees) {
            Role role = employee.getRole();


            int currentCount = employeeCountByRole.getOrDefault(role, 0);

            employeeCountByRole.put(role, currentCount + 1);
        }

        return employeeCountByRole;
    }

    public Employee findEmployeeWithHighestSalary() {
        if (employees.isEmpty()) {
            return null;
        }

        Employee employeeWithHighestSalary = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getFinalSalary()
                    > employeeWithHighestSalary.getFinalSalary()) {
                employeeWithHighestSalary = employee;
            }
        }

        return employeeWithHighestSalary;
    }
}
