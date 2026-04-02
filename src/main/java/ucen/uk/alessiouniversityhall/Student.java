package ucen.uk.alessiouniversityhall;

/**
 * This class extends the Person class and represents a student
 * living in the university hall.
 * It stores student-specific information such as student ID,
 * phone number, course, year of study, diet requirements,
 * ground floor request, and payment details.
 *
 * @author Alessio
 */
public class Student extends Person{

    private final String studentId;
    private final String phone;
    private final String course;
    private final int yearOfStudy;
    private final String diet;
    private final boolean groundFloor;
    private final Payment payment;

    /**
     * Constructs a new Student with personal and academic information.
     *
     * @param fullName the full name of the student
     * @param dob the date of birth in format DD/MM/YYYY
     * @param nationality the nationality of the student
     * @param gender the gender of the student (Male/Female)
     * @param hall the hall assigned to the student
     * @param studentId student identification number
     * @param phone student phone number
     * @param course course of study
     * @param yearOfStudy current year of study (1–5)
     * @param diet diet requirement (Vegan, Vegetarian, Halal, Mixed)
     * @param groundFloor true if ground floor is required
     * @param payment payment details for accommodation
     */
    public Student(String fullName, String dob, String nationality, String gender, Hall hall, String studentId, String phone, String course, int yearOfStudy, String diet, boolean groundFloor, Payment payment) {
        super(fullName, dob, nationality, gender, hall);
        this.studentId = studentId;
        this.phone = phone;
        this.course = course;
        this.yearOfStudy = yearOfStudy;
        this.diet = diet;
        this.groundFloor = groundFloor;
        this.payment = payment;
    }

    /**
     * Returns the student identification number.
     *
     * @return student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Returns the student phone number.
     *
     * @return phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the course of study.
     *
     * @return course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Returns the year of study.
     *
     * @return year of study
     */
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * Returns the diet requirement.
     *
     * @return diet
     */
    public String getDiet() {
        return diet;
    }

    /**
     * Returns whether ground floor accommodation is required.
     *
     * @return true if ground floor is requested
     */
    public boolean isGroundFloor() {
        return groundFloor;
    }

    /**
     * Returns the payment details.
     *
     * @return payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Returns a formatted string representation of the student.
     * Includes personal details and student-specific information.
     *
     * @return formatted student information
     */
    @Override
    public String toString() {

        return  super.toString() +
                "\nStudent ID: " + studentId +
                "\nPhone: " + phone +
                "\nCourse: " + course +
                "\nYear: " + yearOfStudy +
                "\nDiet: " + diet +
                "\nGroundFloor: " + groundFloor +
                "\n" + payment.toString() +
                "\n--------------------------------------";

    }
}
