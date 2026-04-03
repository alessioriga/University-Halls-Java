package ucen.uk.alessiouniversityhall;

import java.time.LocalDateTime;

/**
 * This class extends the Person class and inherits basic personal
 * information such as full name, date of birth, nationality, gender,
 * and assigned hall.
 *
 * @author Alessio
 */
public class Employee extends Person {

    private final String employeeId;
    private final String role;
    private final double salary;

    /**
     * Constructs a new Employee object with personal and job-related information.
     *
     * @param fullName the full name of the employee
     * @param dob the date of birth in format DD/MM/YYYY
     * @param nationality the nationality of the employee
     * @param gender the gender of the employee (Male/Female)
     * @param hall assigned hall
     * @param dateTimeStamp date and time the record was created
     * @param employeeId employee identification number
     * @param role job role
     * @param salary salary of the employee in GBP
     */
    public Employee(String fullName, String dob, String nationality, String gender, Hall hall, LocalDateTime dateTimeStamp, String employeeId, String role, double salary) {

        super(fullName, dob, nationality, gender, hall, dateTimeStamp);

        this.employeeId = employeeId;
        this.role = role;
        this.salary = salary;
    }

    /**
     * Returns the employee identification number.
     *
     * @return employee ID as a String
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Returns the job role of the employee.
     *
     * @return role of the employee
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns the salary of the employee.
     *
     * @return salary in GBP
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns a formatted string representation of the employee.
     * Includes personal details inherited from Person and
     * employee-specific information such as ID, role, and salary.
     *
     * @return formatted employee information
     */
    @Override
    public String toString() {

        return super.toString() +
                "\nEmployee ID: " + employeeId +
                "\nRole: " + role +
                "\nSalary: £" + salary +
                "\n--------------------------------------";
    }
}
