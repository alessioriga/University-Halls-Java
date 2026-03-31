package ucen.uk.alessiouniversityhall;

public class Employee extends Person {
    private String employeeId;
    private String role;
    private double salary;

    public Employee(String fullName, String dob, String nationality, String gender, String hall, String employeeId, String role, double salary) {
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
                "\n Role: " + role +
                "\n Salary: £" + salary +
                "\n--------------------------------------";
    }
}
