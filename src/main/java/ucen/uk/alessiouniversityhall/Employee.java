package ucen.uk.alessiouniversityhall;

public class Employee extends Person {
    private final String employeeId;
    private final String role;
    private final double salary;

    public Employee(String fullName, String dob, String nationality, String gender, Hall hall, String employeeId, String role, double salary) {

        super(fullName, dob, nationality, gender, hall);

        this.employeeId = employeeId;
        this.role = role;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmployee ID: " + employeeId +
                "\nRole: " + role +
                "\nSalary: £" + salary +
                "\n--------------------------------------";
    }
}
