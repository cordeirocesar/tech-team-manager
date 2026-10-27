public class Employee {

    private String name;
    private double salary;
    private Role role;

    public Employee() {
    }

    public Employee(String name, double salary, Role role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getFinalSalary() {
        return salary + role.calculateBonus(salary);
    }
}
